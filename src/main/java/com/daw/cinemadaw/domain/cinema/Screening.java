package com.daw.cinemadaw.domain.cinema;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern= "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime screeningDateTime;
    @Column
    private double precio; 

    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Room room;

    public Screening() {
    }

    public Screening(Movie movie, double precio, Room room, LocalDateTime screeningDateTime) {
        this.movie = movie;
        this.precio = precio;
        this.room = room;
        this.screeningDateTime = screeningDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getScreeningDateTime() {
        return screeningDateTime;
    }

    public void setScreeningDateTime(LocalDateTime screeningDateTime) {
        this.screeningDateTime = screeningDateTime;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
