package com.daw.cinemadaw.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.cinemadaw.domain.cinema.News;
import com.daw.cinemadaw.repository.CinemaRepository;
import com.daw.cinemadaw.service.NewsService;

@Controller
public class HomeController {

    private CinemaRepository cinemaRepository;

    public HomeController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        NewsService newsService = new NewsService();
        ArrayList<News> lista = new ArrayList<>();

        try {
            lista = newsService.getNews();
        } catch (FileNotFoundException ex) {
            System.getLogger(HomeController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        model.addAttribute("lista", lista);
        return "home";
    }

}
