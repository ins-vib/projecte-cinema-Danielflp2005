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
import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.repository.MovieRepository;

@Controller
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("movies/billboard")
    public String cinemes(Model model) {

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("Lista", movies);
        return "movies/billboard";
    }

    @GetMapping("/movie/{id}")
    public String detall(@PathVariable Long id, Model model) {

        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            Movie movie = optional.get();
            model.addAttribute("movie", movie);
            return "/movies/movie-detail";
        }

        return "redirect:/";
    }

    @GetMapping("/movie/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {

        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            Movie movie = optional.get();
            movieRepository.delete(movie);
        }

        return "redirect:/movies/billboard";
    }

    @GetMapping("/movie/create")
    public String newMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "/movies/movie-create";
    }

    @PostMapping("/movie/new")
    public String altaPelicula(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies/billboard";
    }

    @GetMapping("/movie/edit/{id}")
    public String editPelicula(@PathVariable Long id, Model model) {

        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            Movie movie = optional.get();
            model.addAttribute("movie", movie);
            return "/movies/movie-update";
        }

        return "redirect:/billboard";
    }

    @PostMapping("/movie/editar")
    public String editPelicula(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/billboard";
    }

}
