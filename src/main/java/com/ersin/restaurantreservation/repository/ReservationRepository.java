package com.ersin.restaurantreservation.repository;

import com.ersin.restaurantreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}