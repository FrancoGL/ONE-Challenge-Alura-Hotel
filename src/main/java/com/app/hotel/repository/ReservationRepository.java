package com.app.hotel.repository;

import com.app.hotel.model.entity.Reservation;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

  boolean existsReservationByReservationFromDateAndReservationToDate(LocalDate from, LocalDate to);
}
