package com.daw.cinemadaw.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.daw.cinemadaw.domain.cinema.Order;
import com.daw.cinemadaw.repository.ScreeningRepository;
import com.daw.cinemadaw.repository.SeatRepository;
import com.daw.cinemadaw.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final ScreeningRepository screeningRepository;

    public TicketService(TicketRepository ticketRepository, SeatRepository seatRepository,
            ScreeningRepository screeningRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.screeningRepository = screeningRepository;
    }

    public Order crearOrderTickets (Map<Long, List<Long>> cartMap) {

        Order order = new Order();

        //Instruccions per crear l'order a partir del cart 
        // per cada screeningId i llista de seatids al cart: 
        // 1, recuperar la screening i els seients corresponents 
        // 2. crear els tickets associats a l'order 
        // 3. guardar l'order i els tickets a la base de dades 
        // Només intruecions Base de dades per crear una transacci


        return order;
        
    }

}
