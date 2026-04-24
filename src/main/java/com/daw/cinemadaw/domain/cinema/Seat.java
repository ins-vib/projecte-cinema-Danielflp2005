package com.daw.cinemadaw.domain.cinema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La fila es obligatoria")
    @Size(min = 1, max = 5, message = "La fila debe tener entre 1 y 5 caracteres")
    @Column
    private String seatrow;

    @Min(value = 1, message = "El número de asiento debe ser al menos 1")
    @Max(value = 500, message = "El número de asiento no puede superar 500")
    @Column
    private int seatNumber;

    @NotNull(message = "El tipo de asiento es obligatorio")
    @Column
    @Enumerated(EnumType.STRING)
    private SeatType type = SeatType.Standard;

    @Min(value = 0, message = "La posición X no puede ser negativa")
    @Column
    private int x;

    @Min(value = 0, message = "La posición Y no puede ser negativa")
    @Column
    private int y;

    @Column
    private boolean estado;

    @ManyToOne
    Room room;

    public Seat() {
    }

    public Seat(boolean estado, String seatrow, int seatNumber, int x, int y, SeatType type) {

        this.estado = estado;
        this.seatrow = seatrow;
        this.seatNumber = seatNumber;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getSeatrow() {
        return seatrow;
    }

    public void setSeatrow(String seatrow) {
        this.seatrow = seatrow;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "admin/Seat [id=" + id + ", seatrow=" + seatrow + "]";
    }

}
