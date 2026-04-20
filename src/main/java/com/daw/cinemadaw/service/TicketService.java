package com.daw.cinemadaw.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daw.cinemadaw.domain.cinema.Order;
import com.daw.cinemadaw.domain.cinema.OrderStatus;
import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.domain.cinema.Seat;
import com.daw.cinemadaw.domain.cinema.SeatType;
import com.daw.cinemadaw.domain.cinema.Ticket;
import com.daw.cinemadaw.repository.OrderRepository;
import com.daw.cinemadaw.repository.ScreeningRepository;
import com.daw.cinemadaw.repository.SeatRepository;
import com.daw.cinemadaw.repository.TicketRepository;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final ScreeningRepository screeningRepository;
    private final OrderRepository orderRepository;

    public TicketService(TicketRepository ticketRepository, SeatRepository seatRepository,
            ScreeningRepository screeningRepository, OrderRepository orderRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.screeningRepository = screeningRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order crearOrderTickets(Map<Long, List<Long>> cartMap, String clientName, String clientEmail) {

        Order order = new Order();
        order.setOrderDateTime(LocalDateTime.now());
        order.setStatus(OrderStatus.CONFIRMED);
        order.setClientName(clientName);
        order.setClientEmail(clientEmail);

        double totalAmount = 0.0;

        // Per cada screeningId i llista de seatIds al cart:
        for (Map.Entry<Long, List<Long>> entry : cartMap.entrySet()) {
            Long screeningId = entry.getKey();
            List<Long> seatIds = entry.getValue();

            // 1. Recuperar la screening i els seients corresponents
            Screening screening = screeningRepository.findById(screeningId)
                    .orElseThrow(() -> new RuntimeException("Screening no Encontrada: " + screeningId));

            for (Long seatId : seatIds) {
                Seat seat = seatRepository.findById(seatId)
                        .orElseThrow(() -> new RuntimeException("Seient no Encontrado: " + seatId));

                // 2. Crear els tickets associats a l'order
                double price = screening.getPrecio();
                if (seat.getType() == SeatType.Premium) {
                    price += 2.0;
                }

                Ticket ticket = new Ticket(price, order, screening, seat);
                order.getTickets().add(ticket);
                totalAmount += price;
            }
        }

        order.setTotalAmount(totalAmount);

        // 3. Guardar l'order i els tickets a la base de dades
        orderRepository.save(order);

        return order;
    }

}
