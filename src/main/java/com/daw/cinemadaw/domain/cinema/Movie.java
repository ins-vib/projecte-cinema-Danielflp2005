package com.daw.cinemadaw.domain.cinema;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 2, max = 200, message = "El título ha de tener entre 2 y 200 caracteres")
    @Column(nullable = false, length = 200)
    private String title;

    @Min(value = 1, message = "La duración debe ser al menos 1 minuto")
    @Max(value = 999, message = "La duración no puede superar 999 minutos")
    @Column(name = "duration_minutes", nullable = false)
    private int min;

    @NotBlank(message = "El género es obligatorio")
    @Size(min = 2, max = 50, message = "El género ha de tener entre 2 y 50 caracteres")
    @Column(length = 50)
    private String gener;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 2, max = 1000, message = "La descripción ha de tener entre 2 y 1000 caracteres")
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @NotNull(message = "La fecha de estreno es obligatoria")
    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

}
