package com.daw.cinemadaw.config;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.daw.cinemadaw.domain.cinema.Cinema;
import com.daw.cinemadaw.repository.CinemaRepository;

@Component
public class Pruebas implements CommandLineRunner {

    private CinemaRepository cinemaRepository;

    public Pruebas(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cinema cinema1 = new Cinema("Jaume", "Yelmo", "Tarragona", "43003");
        cinemaRepository.save(cinema1);

        List<Cinema> lista = cinemaRepository.findAll();
        for (Cinema cinema : lista) {
            System.out.println(cinema);
        }

        Optional<Cinema> optionalCinema = cinemaRepository.findById(4L);
        if (optionalCinema.isPresent()) {
            Cinema cinema = optionalCinema.get();
            System.out.println(cinema);
            cinema.setCity("Reus");
            cinemaRepository.save(cinema);
        } else {
            System.out.println("No encontrado");
        }

        List<Cinema> lista2 = cinemaRepository.findByCity("Tarragona");
        for (Cinema cinema : lista2) {
            System.out.println(cinema);
        }

        cinemaRepository.delete(lista2.get(0));

        List<Cinema> lista3 = cinemaRepository.findAll();
        for (Cinema cinema : lista3) {
            System.out.println(cinema);
        }

    }

}
