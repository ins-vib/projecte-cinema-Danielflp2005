package com.daw.cinemadaw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

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

    @GetMapping("/admin/seats/room/{id}")
    public String seats(@PathVariable Long id, Model model) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("room", optional.get());
            return "admin/seats/seats";
        }
        return "redirect:/admin/cinemes";
    }

    @GetMapping("/admin/seats/detail/{id}")
    public String seatDetail(@PathVariable Long id, Model model) {
        Optional<Seat> optional = seatRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("seat", optional.get());
            return "admin/seats/seats-detail";
        }
        return "redirect:/admin/cinemes";
    }

    @GetMapping("/admin/seats/new/{id}")
    public String createSeats(@PathVariable Long id, Model model) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) return "redirect:/admin/cinemes";
        Seat seat = new Seat();
        seat.setRoom(room);
        model.addAttribute("seat", seat);
        model.addAttribute("types", SeatType.values());
        return "admin/seats/seats-create";
    }

    @GetMapping("/admin/seats/edit/{id}")
    public String editSeat(@PathVariable Long id, Model model) {
        Optional<Seat> optional = seatRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/admin/cinemes";
        }
        model.addAttribute("seat", optional.get());
        model.addAttribute("types", SeatType.values());
        return "admin/seats/seats-editar";
    }

    @GetMapping("/admin/seats/delete/{id}")
    public String deleteSeat(@PathVariable Long id) {
        Optional<Seat> optional = seatRepository.findById(id);
        if (optional.isPresent()) {
            Seat seat = optional.get();
            seatRepository.delete(seat);
            return "redirect:/admin/seats/room/" + seat.getRoom().getId();
        }
        return "redirect:/admin/cinemes";
    }

    @PostMapping("/admin/seats/new/{id}")
    public String createSeat(@PathVariable Long id, @Valid @ModelAttribute Seat seat, BindingResult result, Model model) {
        roomRepository.findById(id).ifPresent(seat::setRoom);
        if (result.hasErrors()) {
            model.addAttribute("types", SeatType.values());
            return "admin/seats/seats-create";
        }
        seatRepository.save(seat);
        return "redirect:/admin/seats/room/" + id;
    }

    @PostMapping("/admin/seats/edit/{id}")
    public String editSeatPost(@PathVariable Long id, @Valid @ModelAttribute Seat seat, BindingResult result, Model model) {
        Seat existing = seatRepository.findById(seat.getId() != null ? seat.getId() : id).orElse(null);
        if (existing == null) return "redirect:/admin/cinemes";
        Long roomId = existing.getRoom().getId();
        roomRepository.findById(roomId).ifPresent(seat::setRoom);
        if (result.hasErrors()) {
            model.addAttribute("types", SeatType.values());
            return "admin/seats/seats-editar";
        }
        seatRepository.save(seat);
        return "redirect:/admin/seats/room/" + roomId;
    }
}