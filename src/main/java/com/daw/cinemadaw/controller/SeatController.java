package com.daw.cinemadaw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatType;
import com.daw.cinemadaw.repository.RoomRepository;
import com.daw.cinemadaw.repository.SeatRepository;

@Controller
public class SeatController {

    private SeatRepository seatRepository;
    private RoomRepository roomRepository;

    public SeatController(SeatRepository seatRepository, RoomRepository roomRepository) {
        this.seatRepository = seatRepository;
        this.roomRepository = roomRepository;
    }

    // ── Rutas específicas primero ──────────────────────────────
    @GetMapping("/seats/new/{id}")
    public String createSeats(@PathVariable Long id, Model model) {
        Seat seat = new Seat();
        seat.setRoom(roomRepository.findById(id).get());
        model.addAttribute("seat", seat);
        model.addAttribute("types", SeatType.values());
        return "seats/seats-create";
    }

    @GetMapping("/seats/edit/{id}")
    public String editSeat(@PathVariable Long id, Model model) {
        Optional<Seat> optional = seatRepository.findById(id);

        if (optional.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("seat", optional.get());
        model.addAttribute("types", SeatType.values());

        return "seats/seats-editar";

    }

    @GetMapping("/seats/delete/{id}")
    public String deleteSeat(@PathVariable Long id, Model model) {
        Optional<Seat> optional = seatRepository.findById(id);
        if (optional.isPresent()) {
            Seat seat = optional.get();
            seatRepository.delete(seat);
            return "redirect:/seats/room/" + seat.getRoom().getId();
        }
        return "redirect:/seats/room/" + id;
    }

    @PostMapping("/seats/new/{id}")
    public String createSeat(@PathVariable Long id, @ModelAttribute Seat seat) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            seat.setRoom(room.get());
        }
        seatRepository.save(seat);
        return "redirect:/seats/room/" + id;
    }

    @PostMapping("/seats/edit/{id}")
    public String editSeatPost(@PathVariable Long id, @ModelAttribute Seat seat) {
        Long roomId = seat.getRoom().getId();
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            seat.setRoom(room.get());
        }
        seatRepository.save(seat);
        return "redirect:/seats/room/" + roomId;
    }

    // ── Ruta genérica al final ─────────────────────────────────
    @GetMapping("/seats/room/{id}")
    public String seats(@PathVariable Long id, Model model) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("room", optional.get());
            return "seats/seats";
        }
        return "redirect:/";
    }

    @GetMapping("/seats/detail/{id}")
    public String seatDetail(@PathVariable Long id, Model model) {
        Optional<Seat> optional = seatRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("seat", optional.get());
            return "seats/seats-detail";
        }
        return "redirect:/";
    }   

}
