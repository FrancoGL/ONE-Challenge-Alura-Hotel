package com.app.hotel.service.abstraction;

import com.app.hotel.exception.ReservationAlreadyDoneException;
import com.app.hotel.model.request.CreateReservationRequest;
import com.app.hotel.model.response.CreateReservationResponse;

public interface CreateReservation {

  public CreateReservationResponse createReservation(CreateReservationRequest request)
      throws ReservationAlreadyDoneException;
}
