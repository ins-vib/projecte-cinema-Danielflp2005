package com.daw.cinemadaw.cart;

import java.util.List;

import com.daw.cinemadaw.domain.cinema.Screening;
import com.daw.cinemadaw.domain.cinema.Seat;

public record CartEntryView(Screening screening, List<Seat> seats, double subtotal) {}
