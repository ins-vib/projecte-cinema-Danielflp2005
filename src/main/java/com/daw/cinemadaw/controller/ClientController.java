package com.daw.cinemadaw.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.cinemadaw.cart.CartEntryView;
import com.daw.cinemadaw.cart.CartItem;
import com.daw.cinemadaw.cart.CartService;
import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.domain.cinema.Order;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.repository.MovieRepository;
import com.daw.cinemadaw.repository.OrderRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;
import com.daw.cinemadaw.repository.SeatBookingRepository;
import com.daw.cinemadaw.repository.SeatRepository;
import com.daw.cinemadaw.service.OrderService;

@Controller
public class ClientController {

    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final SeatBookingRepository seatBookingRepository;
    private final MovieRepository movieRepository;
    private final CartService cartService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public ClientController(ScreeningRepository screeningRepository,
            SeatRepository seatRepository,
            SeatBookingRepository seatBookingRepository,
            MovieRepository movieRepository,
            CartService cartService,
            OrderService orderService,
            OrderRepository orderRepository) {
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.seatBookingRepository = seatBookingRepository;
        this.movieRepository = movieRepository;
        this.cartService = cartService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    // ── Selección de asientos ────────────────────────────────────────────────

    @GetMapping("/client/screening/{id}/seats")
    public String seatSelection(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/client/billboard";

        Screening screening = optional.get();

        List<Seat> allSeats = seatRepository.findByRoomIdOrderBySeatrowAscSeatNumberAsc(
                screening.getRoom().getId());

        Set<Long> bookedIds = seatBookingRepository.findByScreening(screening)
                .stream().map(b -> b.getSeat().getId()).collect(Collectors.toSet());

        Map<String, List<Seat>> seatsByRow = allSeats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatrow, LinkedHashMap::new, Collectors.toList()));

        // Si esta sesión ya está en el carrito, pre-marcar esos asientos
        CartItem existing = cartService.getItems().get(id);
        Set<Long> preselected = existing != null
                ? Set.copyOf(existing.getSeatIds())
                : Set.of();

        model.addAttribute("screening", screening);
        model.addAttribute("seatsByRow", seatsByRow);
        model.addAttribute("bookedIds", bookedIds);
        model.addAttribute("preselected", preselected);
        model.addAttribute("premiumSurcharge", 2.0);
        return "client/seat-selection";
    }

    // ── Añadir sesión al carrito ─────────────────────────────────────────────

    @PostMapping("/client/screening/{id}/book")
    public String addToCart(@PathVariable Long id,
            @RequestParam(required = false) List<Long> seatIds,
            RedirectAttributes attrs) {

        if (seatIds == null || seatIds.isEmpty()) {
            attrs.addFlashAttribute("error", "Selecciona al menos un asiento.");
            return "redirect:/client/screening/" + id + "/seats";
        }

        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/client/billboard";

        cartService.addOrReplace(id, seatIds);
        attrs.addFlashAttribute("added", optional.get().getMovie().getTitle());
        return "redirect:/client/cart";
    }

    // ── Carrito ──────────────────────────────────────────────────────────────

    @GetMapping("/client/cart")
    public String viewCart(Model model) {
        List<CartEntryView> entries = new ArrayList<>();
        double total = 0;

        for (CartItem item : cartService.getItems().values()) {
            Optional<Screening> screeningOpt = screeningRepository.findById(item.getScreeningId());
            if (screeningOpt.isEmpty()) continue;

            Screening screening = screeningOpt.get();
            List<Seat> seats = new ArrayList<>();

            for (Long seatId : item.getSeatIds()) {
                seatRepository.findById(seatId).ifPresent(seats::add);
            }

            double subtotal = seats.stream().mapToDouble(seat ->
                    seat.getType().name().equals("Premium")
                            ? screening.getPrecio() + 2.0
                            : screening.getPrecio()
            ).sum();

            total += subtotal;
            entries.add(new CartEntryView(screening, seats, subtotal));
        }

        model.addAttribute("cartEntries", entries);
        model.addAttribute("cartTotal", total);
        return "client/cart";
    }

    @PostMapping("/client/cart/remove/{screeningId}")
    public String removeFromCart(@PathVariable Long screeningId) {
        cartService.remove(screeningId);
        return "redirect:/client/cart";
    }

    // ── Finalizar compra ─────────────────────────────────────────────────────

    @PostMapping("/client/cart/checkout")
    public String checkout(@RequestParam String clientName,
            @RequestParam String clientEmail,
            RedirectAttributes attrs) {
        if (cartService.isEmpty()) return "redirect:/client/cart";

        Order order = orderService.createOrderFromCart(cartService, clientName, clientEmail);
        cartService.clear();
        attrs.addFlashAttribute("orderId", order.getId());
        return "redirect:/client/cart/confirm";
    }

    @GetMapping("/client/cart/confirm")
    public String cartConfirm(Model model) {
        return "client/cart-confirm";
    }

    // ── Mis pedidos ──────────────────────────────────────────────────────────

    @GetMapping("/client/my-orders")
    public String myOrders(@RequestParam(required = false) String email, Model model) {
        if (email != null && !email.isBlank()) {
            List<Order> orders = orderRepository.findByClientEmailOrderByOrderDateTimeDesc(email);
            model.addAttribute("orders", orders);
            model.addAttribute("email", email);
        }
        return "client/my-orders";
    }

    @GetMapping("/client/my-orders/{id}")
    public String orderDetail(@PathVariable Long id, Model model) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/client/my-orders";
        model.addAttribute("order", optional.get());
        return "client/order-detail";
    }

    // ── Cartelera y sesiones ─────────────────────────────────────────────────

    @GetMapping("/client/billboard")
    public String billboard(Model model) {
        List<Movie> movies = movieRepository.findMoviesWithFuturesScreenings();
        model.addAttribute("movies", movies);
        return "client/billboard";
    }

    @GetMapping("/client/movie/{id}")
    public String movieSessions(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/client/billboard";

        List<Screening> screenings = screeningRepository.findByMovieIdOrderByScreeningDateTimeAsc(id);
        Map<LocalDate, List<Screening>> byDay = new LinkedHashMap<>();
        for (Screening s : screenings) {
            LocalDate day = s.getScreeningDateTime().toLocalDate();
            byDay.computeIfAbsent(day, k -> new java.util.ArrayList<>()).add(s);
        }
        model.addAttribute("movie", optional.get());
        model.addAttribute("sessionsByDay", byDay);
        return "client/movie-sessions";
    }
}
