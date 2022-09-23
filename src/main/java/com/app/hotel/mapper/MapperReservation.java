package com.app.hotel.mapper;

import com.app.hotel.model.entity.Guest;
import com.app.hotel.model.entity.Reservation;
import com.app.hotel.model.request.CreateReservationRequest;
import com.app.hotel.model.response.CreateReservationResponse;
import com.app.hotel.model.response.GetReservationResponse;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperReservation {

  private final ModelMapper modelMapper;

  @Autowired
  public MapperReservation(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public Reservation map(CreateReservationRequest request) {
    return modelMapper.map(request, Reservation.class);
  }

  public CreateReservationResponse map(Reservation reservation) {
    return modelMapper.map(reservation, CreateReservationResponse.class);
  }

  public GetReservationResponse map(List<Reservation> reservations, Guest guest) {
    GetReservationResponse getReservationResponse = new GetReservationResponse();
    List<CreateReservationResponse> reservationResponses = new ArrayList<>();
    reservations.forEach(e -> {
      reservationResponses.add(map(e));
    });
    getReservationResponse.setReservations(reservationResponses);
    return getReservationResponse;
  }
}
