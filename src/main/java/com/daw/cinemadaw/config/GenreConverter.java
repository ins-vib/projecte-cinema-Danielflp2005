package com.daw.cinemadaw.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.daw.cinemadaw.domain.cinema.Genre;
import com.daw.cinemadaw.repository.GenreRepository;

@Component
public class GenreConverter implements Converter<String, Genre> {

    private final GenreRepository genreRepository;

    public GenreConverter(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre convert(String id) {
        if (id == null || id.isBlank()) return null;
        return genreRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
