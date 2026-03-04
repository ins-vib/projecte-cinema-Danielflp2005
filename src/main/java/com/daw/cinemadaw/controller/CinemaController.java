package com.daw.cinemadaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.cinemadaw.domain.cinema.Cinema;
import com.daw.cinemadaw.repository.CinemaRepository;

@Controller
public class CinemaController {

    private CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemes")
    public String cinemes(Model model) {

        List<Cinema> cines = cinemaRepository.findAll();
        model.addAttribute("Lista", cines);
        return "cinemes";
    }

    @GetMapping("/cinema/{id}")
    public String detall(@PathVariable Long id, Model model) {

        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            Cinema cinema = optional.get();
            model.addAttribute("cinema", cinema);
            return "detail-cinema";
        }

        return "redirect:/";
    }

    @GetMapping("/cinema/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {

        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            Cinema cinema = optional.get();
            cinemaRepository.delete(cinema);
        }

        return "redirect:/cinemes";
    }

    @GetMapping("/cinemes/create")
    public String newCinema(Model model) {
        Cinema cinema = new Cinema();
        cinema.setCity("Tarragona");
        model.addAttribute("cinema", cinema);
        return "cinema-create";
    }

    @PostMapping("/cinemes/new")
    public String altaCinema(@ModelAttribute Cinema cinema) {
        cinemaRepository.save(cinema);
        return "redirect:/cinemes";
    }

    @GetMapping("/cinemes/edit/{id}")
    public String editCinema(@PathVariable Long id, Model model) {

        Optional<Cinema> optional = cinemaRepository.findById(id);
        if (optional.isPresent()) {
            Cinema cinema = optional.get();
            model.addAttribute("cinema", cinema);
            return "cinema-update";
        }

        return "redirect:/cinemes";
    }

    @PostMapping("/cinemes/editar")
    public String editCinema(@ModelAttribute Cinema cinema) {
        cinemaRepository.save(cinema);
        return "redirect:/cinemes";
    }

}
