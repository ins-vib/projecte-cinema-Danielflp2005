package com.daw.cinemadaw.domain.cinema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cinemaName;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String postalCode;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
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
