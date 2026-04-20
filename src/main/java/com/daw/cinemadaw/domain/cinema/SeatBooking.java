package com.daw.cinemadaw.domain.cinema;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"seat_id", "screening_id"}))
public class SeatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Screening screening;

    public SeatBooking() {}

    public SeatBooking(Seat seat, Screening screening) {
        this.seat = seat;
        this.screening = screening;
    }

    public Long getId() { return id; }
    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }
    public Screening getScreening() { return screening; }
    public void setScreening(Screening screening) { this.screening = screening; }
}
