package com.app.hotel.model.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

  @Column(name = "PAY", nullable = false)
  private Long pay;

  @CreationTimestamp
  @Column(name = "TIMESTAMP", nullable = false)
  private Timestamp timestamp;

  @OneToOne
  private Guest guest;
}
