package com.daw.cinemadaw.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.repository.MovieRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;

import jakarta.validation.Valid;

@Controller
public class MovieController {

    private MovieRepository movieRepository;
    private ScreeningRepository screeningRepository;

    public MovieController(MovieRepository movieRepository, ScreeningRepository screeningRepository) {
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
    }

    @GetMapping("/admin/movies/billboard")
    public String movies(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("Lista", movies);
        return "admin/movies/billboard";
    }

    @GetMapping("/admin/movie/{id}")
    public String detall(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("movie", optional.get());
            return "admin/movies/movie-detail";
        }
        return "redirect:/admin/movies/billboard";
    }

    @GetMapping("/admin/movie/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            movieRepository.delete(optional.get());
        }
        return "redirect:/admin/movies/billboard";
    }

    @GetMapping("/admin/movie/create")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "admin/movies/movie-create";
    }

    @PostMapping("/admin/movie/new")
    public String altaPelicula(@Valid @ModelAttribute Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/movies/movie-create";
        }
        movieRepository.save(movie);
        return "redirect:/admin/movies/billboard";
    }

    @GetMapping("/admin/movie/edit/{id}")
    public String editPelicula(@PathVariable Long id, Model model) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            model.addAttribute("movie", optional.get());
            return "admin/movies/movie-update";
        }
        return "redirect:/admin/movies/billboard";
    }

    @PostMapping("/admin/movie/editar")
    public String editPelicula(@Valid @ModelAttribute Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/movies/movie-update";
        }
        movieRepository.save(movie);
        return "redirect:/admin/movies/billboard";
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