package com.app.hotel.model.response;

import com.app.hotel.model.entity.Guest;
import com.app.hotel.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetReservationResponse {

  @JsonProperty("reservations")
  private List<CreateReservationResponse> reservations;
}
