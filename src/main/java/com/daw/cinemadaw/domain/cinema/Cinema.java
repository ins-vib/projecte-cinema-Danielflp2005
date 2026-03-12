package com.daw.cinemadaw.domain.cinema;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cinema es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre ha de tener entre 2 y 100 caracteres")
    @Column
    private String cinemaName;
    @NotBlank(message = "El nombre de la direccion es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre ha de tener entre 2 y 100 caracteres")
    @Column
    private String address;
    @NotBlank(message = "El nombre de la ciudad es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre ha de tener entre 2 y 100 caracteres")
    @Column
    private String city;
    @NotBlank(message = "El codigo postal es obligatorio")
    @Pattern(regexp = "\\d{5}", message = "El codigo postal ha de tener 5 digitos")
    @Column
    private String postalCode;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Room> rooms = new ArrayList<>();

    public Cinema() {
    }

    public Cinema(String address, String cinemaName, String city, String postalCode) {
        this.address = address;
        this.cinemaName = cinemaName;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cinema{");
        sb.append("id=").append(id);
        sb.append(", cinemaName=").append(cinemaName);
        sb.append(", address=").append(address);
        sb.append(", city=").append(city);
        sb.append(", postalCode=").append(postalCode);
        sb.append('}');
        return sb.toString();
    }

}
