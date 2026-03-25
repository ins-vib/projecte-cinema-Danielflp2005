package com.daw.cinemadaw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.repository.MovieRepository;
import com.daw.cinemadaw.repository.RoomRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;

@Controller
public class ScreeningController {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;

    public ScreeningController(ScreeningRepository screeningRepository,
            MovieRepository movieRepository,
            RoomRepository roomRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    // ── Públicas ───────────────────────────────────────────────
    @GetMapping("/screenings")
    public String listMovies(Model model) {
        List<Movie> movies = screeningRepository.findAll()
                .stream()
                .map(Screening::getMovie)
                .distinct()
                .toList();
        model.addAttribute("movies", movies);
        return "admin/screenings/screenings";
    }

    @GetMapping("/screenings/movie/{id}")
    public String byMovie(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) return "redirect:/screenings";
        List<Screening> screenings = screeningRepository.findByMovie(movie.get());
        model.addAttribute("movie", movie.get());
        model.addAttribute("screenings", screenings);
        return "admin/screenings/screenings-bymovies";
    }

    @GetMapping("/screenings/room/{id}")
    public String byRoom(@PathVariable Long id, Model model) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) return "redirect:/screenings";
        List<Screening> screenings = screeningRepository.findByRoom(room.get());
        model.addAttribute("room", room.get());
        model.addAttribute("screenings", screenings);
        return "admin/screenings/screening-byroom";
    }

    @GetMapping("/screening/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/screenings";
        model.addAttribute("screening", optional.get());
        return "admin/screenings/screening-details";
    }

    // ── Admin ──────────────────────────────────────────────────
    @GetMapping("/admin/screening/create/{movieId}")
    public String createForm(@PathVariable Long movieId, Model model) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isEmpty()) return "redirect:/movies/billboard";
        Screening screening = new Screening();
        screening.setMovie(movie.get());
        model.addAttribute("screening", screening);
        model.addAttribute("rooms", roomRepository.findAll());
        return "admin/screenings/screening-create";
    }

    @GetMapping("/admin/screening/create")
    public String createFormFull(Model model) {
        Screening screening = new Screening();
        screening.setMovie(new Movie());
        screening.setRoom(new Room());
        model.addAttribute("screening", screening);
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());
        return "admin/screenings/screening-createfull";
    }

    @PostMapping("/admin/screening/new/{movieId}")
    public String save(@PathVariable Long movieId, @ModelAttribute Screening screening) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        Optional<Room> room = roomRepository.findById(screening.getRoom().getId());
        movie.ifPresent(screening::setMovie);
        room.ifPresent(screening::setRoom);
        screeningRepository.save(screening);
        return "redirect:/screenings/movie/" + movieId;
    }

    @PostMapping("/admin/screening/new")
    public String saveFull(@ModelAttribute Screening screening) {
        Optional<Movie> movie = movieRepository.findById(screening.getMovie().getId());
        Optional<Room> room = roomRepository.findById(screening.getRoom().getId());
        movie.ifPresent(screening::setMovie);
        room.ifPresent(screening::setRoom);
        screeningRepository.save(screening);
        return "redirect:/screenings";
    }

    @GetMapping("/admin/screening/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty()) return "redirect:/screenings";
        model.addAttribute("screening", optional.get());
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());
        return "admin/screenings/screening-update";
    }

    @PostMapping("/admin/screening/edit")
    public String edit(@ModelAttribute Screening screening) {
        Optional<Movie> movie = movieRepository.findById(screening.getMovie().getId());
        Optional<Room> room = roomRepository.findById(screening.getRoom().getId());
        movie.ifPresent(screening::setMovie);
        room.ifPresent(screening::setRoom);
        screeningRepository.save(screening);
        return "redirect:/screenings";
    }

    @GetMapping("/admin/screening/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Screening> optional = screeningRepository.findById(id);
        Long movieId = optional.map(s -> s.getMovie().getId()).orElse(null);
        screeningRepository.deleteById(id);
        return movieId != null ? "redirect:/screenings/movie/" + movieId : "redirect:/screenings";
    }
}