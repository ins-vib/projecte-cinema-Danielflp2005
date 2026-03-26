package com.daw.cinemadaw.controller;

import java.time.LocalDate;
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

import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatBooking;
import com.daw.cinemadaw.repository.MovieRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;
import com.daw.cinemadaw.repository.SeatBookingRepository;
import com.daw.cinemadaw.repository.SeatRepository;

@Controller
public class ClientController {

    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final SeatBookingRepository seatBookingRepository;
    private final MovieRepository movieRepository;

    public ClientController(ScreeningRepository screeningRepository,
            SeatRepository seatRepository,
            SeatBookingRepository seatBookingRepository,
            MovieRepository movieRepository) {
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
        this.seatBookingRepository = seatBookingRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/client/screening/{id}/seats")
    public String seatSelection(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/client/billboard";
        }
        Screening screening = optional.get();

        List<Seat> allSeats = seatRepository.findByRoomIdOrderBySeatrowAscSeatNumberAsc(
                screening.getRoom().getId());

        Set<Long> bookedIds = seatBookingRepository.findByScreening(screening)
                .stream().map(b -> b.getSeat().getId()).collect(Collectors.toSet());

        Map<String, List<Seat>> seatsByRow = allSeats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatrow, LinkedHashMap::new, Collectors.toList()));

        model.addAttribute("screening", screening);
        model.addAttribute("seatsByRow", seatsByRow);
        model.addAttribute("bookedIds", bookedIds);
        model.addAttribute("premiumSurcharge", 2.0);
        return "client/seat-selection";
    }

    @PostMapping("/client/screening/{id}/book")
    public String bookSeats(@PathVariable Long id,
            @RequestParam(required = false) List<Long> seatIds,
            RedirectAttributes attrs) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/client/billboard";
        }
        Screening screening = optional.get();

        int booked = 0;
        if (seatIds != null) {
            for (Long seatId : seatIds) {
                Optional<Seat> seatOpt = seatRepository.findById(seatId);
                if (seatOpt.isPresent()
                        && !seatBookingRepository.existsBySeatAndScreening(seatOpt.get(), screening)) {
                    seatBookingRepository.save(new SeatBooking(seatOpt.get(), screening));
                    booked++;
                }
            }
        }
        attrs.addFlashAttribute("count", booked);
        return "redirect:/client/screening/" + id + "/confirm";
    }

    @GetMapping("/client/screening/{id}/confirm")
    public String confirm(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/client/billboard";
        }
        model.addAttribute("screening", optional.get());
        return "client/booking-confirm";
    }

    @GetMapping("/client/billboard")
    public String billboard(Model model) {
        List<Movie> movies = movieRepository.findMoviesWithFuturesScreenings();
        model.addAttribute("movies", movies);
        return "client/billboard";
    }

    @GetMapping("/client/movie/{id}")
    public String movieSessions(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/client/billboard";
        }
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
