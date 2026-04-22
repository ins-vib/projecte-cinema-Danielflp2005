package com.daw.cinemadaw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.cinemadaw.domain.cinema.Movie;
import com.daw.cinemadaw.domain.cinema.Room;
import com.daw.cinemadaw.domain.cinema.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByMovie(Movie movie);
    List<Screening> findByRoom(Room room);
    List<Screening> findByMovieIdOrderByScreeningDateTimeAsc(Long movieId);
    List<Screening> findAllByOrderByScreeningDateTimeAsc();
}