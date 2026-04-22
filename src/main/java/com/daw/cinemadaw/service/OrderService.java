package com.daw.cinemadaw.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daw.cinemadaw.cart.CartItem;
import com.daw.cinemadaw.cart.CartService;
import com.daw.cinemadaw.domain.cinema.Order;
import com.daw.cinemadaw.domain.cinema.OrderStatus;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatBooking;
import com.daw.cinemadaw.domain.cinema.Ticket;
import com.daw.cinemadaw.repository.OrderRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;
import com.daw.cinemadaw.repository.SeatBookingRepository;
import com.daw.cinemadaw.repository.SeatRepository;
import com.daw.cinemadaw.repository.TicketRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final SeatBookingRepository seatBookingRepository;

    public OrderService(OrderRepository orderRepository, TicketRepository ticketRepository,
            ScreeningRepository screeningRepository, SeatRepository seatRepository,
            SeatBookingRepository seatBookingRepository) {
        this.orderRepository = orderRepository;
        this.ticketRepository = ticketRepository;
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.seatBookingRepository = seatBookingRepository;
    }

    @Transactional(isolation = org.springframework.transaction.annotation.Isolation.SERIALIZABLE)
    public Order createOrderFromCart(CartService cartService, String clientName, String clientEmail) {
        Order order = new Order(LocalDateTime.now(), 0, clientName, clientEmail, OrderStatus.CONFIRMED);
        order = orderRepository.save(order);

        double totalAmount = 0;

        for (CartItem item : cartService.getItems().values()) {
            Optional<Screening> screeningOpt = screeningRepository.findById(item.getScreeningId());
            if (screeningOpt.isEmpty()) continue;
            Screening screening = screeningOpt.get();

            for (Long seatId : item.getSeatIds()) {
                Optional<Seat> seatOpt = seatRepository.findById(seatId);
                if (seatOpt.isEmpty()) continue;
                Seat seat = seatOpt.get();

                if (seatBookingRepository.existsBySeatAndScreening(seat, screening)) {
                    throw new SeatsAlreadyBookedException();
                }

                seatBookingRepository.save(new SeatBooking(seat, screening));

                double price = seat.getType().name().equals("Premium")
                        ? screening.getPrecio() + 2.0
                        : screening.getPrecio();
                totalAmount += price;

                ticketRepository.save(new Ticket(price, order, screening, seat));
            }
        }

        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }
}
