package com.daw.cinemadaw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.cinemadaw.domain.cinema.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientEmailOrderByOrderDateTimeDesc(String clientEmail);
}
