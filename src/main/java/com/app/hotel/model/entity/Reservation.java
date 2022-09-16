package com.app.hotel.model.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RESERVATIONS")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "RESERVATION_ID", nullable = false, unique = true)
  private Long reservationId;

  @Column(name = "RESERVATION_FROM", nullable = false)
  private LocalDate reservationFromDate;

  @Column(name = "RESERVATION_TO", nullable = false)
  private LocalDate reservationToDate;

  @Column(name = "TIMESTAMP", nullable = false)
  private Timestamp timestamp;

}
