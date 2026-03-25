package com.daw.cinemadaw.controller;

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
import com.daw.cinemadaw.repository.CinemaRepository;

import jakarta.validation.Valid;

@Controller
public class CinemaController {

    private CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    // ── Públicas ───────────────────────────────────────────────
    @GetMapping("/cinemes")
    public String cinemes(Model model) {
        List<Cinema> cines = cinemaRepository.findAll();
        model.addAttribute("Lista", cines);
        return "admin/cinemas/cinemes";
    }

    @GetMapping("/cinema/{id}")
    public String detall(@PathVariable Long id, Model model) {
        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("cinema", optional.get());
            return "admin/cinemas/detail-cinema";
        }
        return "redirect:/";
    }

    // ── Admin ──────────────────────────────────────────────────
    @GetMapping("/admin/cinema/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            cinemaRepository.delete(optional.get());
        }
        return "redirect:/cinemes";
    }

    @GetMapping("/admin/cinemes/create")
    public String newCinema(Model model) {
        Cinema cinema = new Cinema();
        cinema.setCity("Tarragona");
        model.addAttribute("cinema", cinema);
        return "admin/cinemas/cinema-create";
    }

    @PostMapping("/admin/cinemes/new")
    public String altaCinema(@Valid @ModelAttribute Cinema cinema, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/cinemas/cinema-create";
        }
        cinemaRepository.save(cinema);
        return "redirect:/cinemes";
    }

    @GetMapping("/admin/cinemes/edit/{id}")
    public String editCinema(@PathVariable Long id, Model model) {
        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("cinema", optional.get());
            return "admin/cinemas/cinema-update";
        }
        return "redirect:/cinemes";
    }

    @PostMapping("/admin/cinemes/editar")
    public String editCinema(@Valid @ModelAttribute Cinema cinema, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/cinemas/cinema-update";
        }
        cinemaRepository.save(cinema);
        return "redirect:/cinemes";
    }
}