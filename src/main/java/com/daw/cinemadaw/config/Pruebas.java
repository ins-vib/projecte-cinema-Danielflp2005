package com.daw.cinemadaw.config;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.daw.cinemadaw.domain.cinema.Cinema;
import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatType;
import com.daw.cinemadaw.repository.CinemaRepository;
import com.daw.cinemadaw.repository.RoomRepository;
import com.daw.cinemadaw.repository.SeatRepository;

import jakarta.transaction.Transactional;

@Transactional
@Component
public class Pruebas implements CommandLineRunner {

    private CinemaRepository cinemaRepository;
    private RoomRepository roomRepository;
    private SeatRepository seatRepository;

    public Pruebas(CinemaRepository cinemaRepository, RoomRepository roomRepository, SeatRepository seatRepository) {
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
    }

    @Transactional
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
        // System.out.println(room2.getCinema().getCinemaName());

        Cinema cine3D = new Cinema("Jaume", "Cine 3D", "Tarragona", "43003");
        Room room3D1 = new Room(500, "Sala 3D 1");
        room3D1.setCinema(cine3D);
        cine3D.getRooms().add(room3D1);
        cinemaRepository.save(cine3D);

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

        Cinema cineIMAX = new Cinema("Gavarras, 46", "IMAX CINE", "Gavarras", "23432");
        Room roomIMAX1 = new Room(200, "Sala IMAX 1");
        roomIMAX1.setCinema(cineIMAX);
        Room roomIMAX2 = new Room(200, "Sala IMAX 1");
        roomIMAX2.setCinema(cineIMAX);
        cineIMAX.getRooms().add(roomIMAX1);
        cineIMAX.getRooms().add(roomIMAX2);
        cinemaRepository.save(cineIMAX);

        List<Room> lista = roomRepository.findAll();
        for (Room rooms : lista) {
            System.out.println(rooms);

            int capacidad = rooms.getCapacity();
            int asientosPorFila = 10;

            for (int i = 0; i < capacidad; i++) {

                int fila = i / asientosPorFila;
                int numero = i % asientosPorFila;

                Seat seat = new Seat(true, "F" + fila, numero, numero, fila, SeatType.Standard);
                seat.setRoom(rooms);
                seatRepository.save(seat);

            }
        }

        Optional<Cinema> optionalC = cinemaRepository.findById(1L);
        if (optionalC.isPresent()) {
            Cinema c = optionalC.get();
            System.out.println(c);

            List<Room> salas = c.getRooms();
            for (Room r : salas) {
                System.out.println(r);
                List<Seat> sillas = r.getSeat();
                for (Seat s : sillas) {
                    System.out.println(s);
                }
            }
        }

    }

}
