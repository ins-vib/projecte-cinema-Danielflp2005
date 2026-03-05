package com.daw.cinemadaw.domain.cinema;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private int min;
    @Column
    private String gener;
    @Column
    private String descripcion;
    @Column
    private LocalDate date = LocalDate.now();
    @Column
    private String posterUrl;

    public Movie() {
    }

    public Movie(String descripcion, String gener, int min, String title) {
        this.descripcion = descripcion;
        this.gener = gener;
        this.min = min;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie{");
        sb.append("id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", min=").append(min);
        sb.append(", gener=").append(gener);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }


}
