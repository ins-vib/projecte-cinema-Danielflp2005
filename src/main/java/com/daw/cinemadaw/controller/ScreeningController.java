package com.daw.cinemadaw.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/admin/screenings")
    public String listMovies(Model model) {
        // Obtenemos las SESIONES ordenadas por fecha
        List<Screening> screenings = screeningRepository.findAllByOrderByScreeningDateTimeAsc();
        model.addAttribute("screenings", screenings);

        // Si tu vista "screenings.html" aún necesita la lista de películas para un
        // selector:
        model.addAttribute("movies", movieRepository.findAll());

        return "admin/screenings/screenings";
    }

    @GetMapping("/admin/screenings/movie/{id}")
    public String byMovie(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty())
            return "redirect:/admin/screenings";

        // USAR EL MÉTODO ORDENADO DEL REPO
        List<Screening> screenings = screeningRepository.findByMovieIdOrderByScreeningDateTimeAsc(id);

        model.addAttribute("movie", movie.get());
        model.addAttribute("screenings", screenings);
        return "admin/screenings/screenings-bymovies";
    }

    @GetMapping("/admin/screenings/room/{id}")
    public String byRoom(@PathVariable Long id, Model model) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty())
            return "redirect:/admin/screenings";

        // Aquí deberías crear en el Repo: findByRoomIdOrderByScreeningDateTimeAsc(id)
        // O usar este filtro temporal:
        List<Screening> screenings = screeningRepository.findByRoom(room.get());
        screenings.sort((a, b) -> a.getScreeningDateTime().compareTo(b.getScreeningDateTime()));

        model.addAttribute("room", room.get());
        model.addAttribute("screenings", screenings);
        return "admin/screenings/screening-byroom";
    }

    @GetMapping("/admin/screening/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty())
            return "redirect:/admin/screenings";
        model.addAttribute("screening", optional.get());
        return "admin/screenings/screening-details";
    }

    @GetMapping("/admin/screening/create/{movieId}")
    public String createForm(@PathVariable Long movieId, Model model) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isEmpty())
            return "redirect:/admin/movies/billboard";
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
    public String save(@PathVariable Long movieId, @ModelAttribute Screening screening,
            RedirectAttributes attrs) {
        movieRepository.findById(movieId).ifPresent(screening::setMovie);
        resolveRoom(screening);
        if (screening.getRoom() == null) {
            attrs.addFlashAttribute("error", "Debes seleccionar una sala.");
            return "redirect:/admin/screening/create/" + movieId;
        }
        screeningRepository.save(screening);
        return "redirect:/admin/screenings/movie/" + movieId;
    }

    @PostMapping("/admin/screening/new")
    public String saveFull(@ModelAttribute Screening screening, RedirectAttributes attrs) {
        resolveMovie(screening);
        resolveRoom(screening);
        if (screening.getMovie() == null || screening.getRoom() == null) {
            attrs.addFlashAttribute("error", "Debes seleccionar una película y una sala.");
            return "redirect:/admin/screening/create";
        }
        screeningRepository.save(screening);
        return "redirect:/admin/screenings";
    }

    @GetMapping("/admin/screening/edit/{id}")
    public String editForm(@PathVariable Long id, Model model,
            @RequestHeader(value = "Referer", required = false) String referer) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty())
            return "redirect:/admin/screenings";
        model.addAttribute("screening", optional.get());
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("movies", movieRepository.findAll());
        // Pass caller context so the form can return to the right list
        String returnUrl = (referer != null && referer.contains("/screenings/room/"))
                ? referer.replaceAll(".*(/admin/screenings/room/\\d+).*", "$1")
                : "/admin/screenings";
        model.addAttribute("returnUrl", returnUrl);
        return "admin/screenings/screening-update";
    }

    @PostMapping("/admin/screening/edit")
    public String edit(@ModelAttribute Screening screening,
            @RequestParam(required = false) String returnUrl) {
        resolveMovie(screening);
        resolveRoom(screening);
        screeningRepository.save(screening);
        String redirect = (returnUrl != null && !returnUrl.isBlank()) ? returnUrl : "/admin/screenings";
        return "redirect:" + redirect;
    }

    private void resolveMovie(Screening screening) {
        if (screening.getMovie() != null && screening.getMovie().getId() != null) {
            movieRepository.findById(screening.getMovie().getId()).ifPresent(screening::setMovie);
        } else {
            screening.setMovie(null); // prevent cascade-insert of transient entity
        }
    }

    private void resolveRoom(Screening screening) {
        if (screening.getRoom() != null && screening.getRoom().getId() != null) {
            roomRepository.findById(screening.getRoom().getId()).ifPresent(screening::setRoom);
        } else {
            screening.setRoom(null); // prevent cascade-insert of transient entity
        }
    }

    @GetMapping("/admin/screening/delete/{id}")
    public String delete(@PathVariable Long id,
            @RequestHeader(value = "Referer", required = false) String referer) {
        Optional<Screening> optional = screeningRepository.findById(id);
        if (optional.isEmpty())
            return "redirect:/admin/screenings";

        Screening screening = optional.get();
        Long movieId = screening.getMovie() != null ? screening.getMovie().getId() : null;
        Long roomId = screening.getRoom() != null ? screening.getRoom().getId() : null;
        screeningRepository.deleteById(id);

        // Return to byRoom view if that's where the action was triggered
        if (referer != null && referer.contains("/screenings/room/") && roomId != null) {
            return "redirect:/admin/screenings/room/" + roomId;
        }
        return movieId != null ? "redirect:/admin/screenings/movie/" + movieId : "redirect:/admin/screenings";
    }
}