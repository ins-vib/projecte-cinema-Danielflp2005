package com.daw.cinemadaw.config;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.daw.cinemadaw.domain.cinema.Cinema;
import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.repository.CinemaRepository;
import com.daw.cinemadaw.repository.RoomRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class Pruebas implements CommandLineRunner {

    private CinemaRepository cinemaRepository;
    private RoomRepository roomRepository;

    public Pruebas(CinemaRepository cinemaRepository, RoomRepository roomRepository) {
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cinema cinema1 = new Cinema("Jaume", "Yelmo", "Tarragona", "43003");
        cinemaRepository.save(cinema1);

        Room room = new Room(50, "Sala 1");
        room.setCinema(cinema1);
        roomRepository.save(room);

        Room room1 = new Room(60, "Sala 2");
        room1.setCinema(cinema1);
        roomRepository.save(room1);

        Room room2 = new Room(70, "Sala 3");
        room2.setCinema(cinema1);
        roomRepository.save(room2);

        System.out.println(room2.getCinema().getCinemaName());

        Optional<Cinema> optionalCinema = cinemaRepository.findById(1L);
        if (optionalCinema.isPresent()) {
            Cinema cinema = optionalCinema.get();
            List<Room> rooms = cinema.getRooms();
            for (Room roomba : rooms) {
                System.out.println(roomba);
            }
        } else {
            System.out.println("No encontrado");
        }

        //     List<Cinema> lista = cinemaRepository.findAll();
        //     for (Cinema cinema : lista) {
        //         System.out.println(cinema);
        //     }
        //     Optional<Cinema> optionalCinema = cinemaRepository.findById(4L);
        //     if (optionalCinema.isPresent()) {
        //         Cinema cinema = optionalCinema.get();
        //         System.out.println(cinema);
        //         cinema.setCity("Reus");
        //         cinemaRepository.save(cinema);
        //     } else {
        //         System.out.println("No encontrado");
        //     }
        //     List<Cinema> lista2 = cinemaRepository.findByCity("Tarragona");
        //     for (Cinema cinema : lista2) {
        //         System.out.println(cinema);
        //     }
        //     cinemaRepository.delete(lista2.get(0));
        //     List<Cinema> lista3 = cinemaRepository.findAll();
        //     for (Cinema cinema : lista3) {
        //         System.out.println(cinema);
        //     }
    }

}
