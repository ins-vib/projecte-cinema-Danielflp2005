package com.daw.cinemadaw.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.cinemadaw.domain.cinema.Cinema;
import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatType;
import com.daw.cinemadaw.repository.CinemaRepository;
import com.daw.cinemadaw.repository.RoomRepository;
import com.daw.cinemadaw.repository.SeatRepository;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class RoomController {

    private RoomRepository roomRepository;
    private CinemaRepository cinemaRepository;
    private SeatRepository seatRepository;

    public RoomController(RoomRepository roomRepository, CinemaRepository cinemaRepository,
            SeatRepository seatRepository) {
        this.roomRepository = roomRepository;
        this.cinemaRepository = cinemaRepository;
        this.seatRepository = seatRepository;
    }

    @GetMapping("/admin/room/{id}")
    public String detall(@PathVariable Long id, Model model) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/admin/cinemes";
        }
        model.addAttribute("room", optional.get());
        return "admin/rooms/room-detail";
    }

    @GetMapping("/admin/room/create/{cinemaId}")
    public String newRoom(@PathVariable Long cinemaId, Model model) {
        Room room = new Room();
        Cinema cinema = new Cinema();
        cinema.setId(cinemaId);
        room.setCinema(cinema);
        model.addAttribute("room", room);
        return "admin/rooms/room-create";
    }

    @GetMapping("/admin/room/edit/{id}")
    public String editRoom(@PathVariable Long id, Model model) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("room", optional.get());
            return "admin/rooms/room-update";
        }
        return "redirect:/admin/cinemes";
    }

    @Transactional
    @PostMapping("/admin/room/editar")
    public String editRoom(@Valid @ModelAttribute Room room, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/rooms/room-update";
        }
        Long cinemaid = room.getCinema().getId();
        Long roomId = room.getId();

        Optional<Cinema> cinema = cinemaRepository.findById(cinemaid);
        Optional<Room> existingRoom = roomRepository.findById(roomId);

        if (existingRoom.isPresent() && cinema.isPresent()) {
            Room roomToUpdate = existingRoom.get();
            int oldCapacity = roomToUpdate.getSeat().size();
            int newCapacity = room.getCapacity();

            roomToUpdate.setName(room.getName());
            roomToUpdate.setCapacity(newCapacity);
            roomToUpdate.setCinema(cinema.get());

            if (newCapacity != oldCapacity) {
                int cols = 10;
                if (newCapacity < oldCapacity) {
                    // Keep the first newCapacity seats (preserving their types), delete the rest
                    List<Seat> sorted = new ArrayList<>(roomToUpdate.getSeat());
                    sorted.sort(Comparator.comparingInt(Seat::getSeatNumber));
                    List<Seat> toRemove = sorted.subList(newCapacity, sorted.size());
                    roomToUpdate.getSeat().removeAll(toRemove);
                } else {
                    // Keep all existing seats and append new Standard seats for the added capacity
                    for (int i = oldCapacity; i < newCapacity; i++) {
                        Seat seat = new Seat();
                        seat.setSeatNumber((i % cols) + 1);
                        seat.setSeatrow(String.valueOf((char) ('A' + i / cols)));
                        seat.setX(i % cols);
                        seat.setY(i / cols);
                        seat.setType(SeatType.Standard);
                        seat.setEstado(false);
                        seat.setRoom(roomToUpdate);
                        roomToUpdate.getSeat().add(seat);
                    }
                }
            }

            roomRepository.save(roomToUpdate);
        }
        return "redirect:/admin/cinema/" + cinemaid;
    }

    @GetMapping("/admin/room/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isPresent()) {
            Room room = optional.get();
            Long cinemaid = room.getCinema().getId();
            roomRepository.delete(room);
            return "redirect:/admin/cinema/" + cinemaid;
        }
        return "redirect:/admin/cinemes";
    }

    @PostMapping("/admin/room/new")
    public String altaRoom(@Valid @ModelAttribute Room room, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/rooms/room-create";
        }
        Long cinemaid = room.getCinema().getId();
        Optional<Cinema> cinema = cinemaRepository.findById(cinemaid);
        if (cinema.isPresent()) {
            room.setCinema(cinema.get());
        }
        roomRepository.save(room);

        int cols = 10;
        for (int i = 0; i < room.getCapacity(); i++) {
            Seat seat = new Seat();
            seat.setSeatNumber((i % cols) + 1);
            seat.setSeatrow(String.valueOf((char) ('A' + i / cols)));
            seat.setX(i % cols);
            seat.setY(i / cols);
            seat.setType(SeatType.Standard);
            seat.setEstado(false);
            seat.setRoom(room);
            seatRepository.save(seat);
        }
        return "redirect:/admin/cinema/" + cinemaid;
    }
}