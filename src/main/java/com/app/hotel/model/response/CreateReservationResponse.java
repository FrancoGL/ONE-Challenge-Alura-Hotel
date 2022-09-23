package com.app.hotel.model.response;

import com.app.hotel.model.entity.Guest;
import java.time.LocalDate;

public class CreateReservationResponse {

  private LocalDate reservationFromDate;

  private LocalDate reservationToDate;

  private String pay;

  private GetGuestResponse guest;
}
