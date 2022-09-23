package com.app.hotel.mapper;

import com.app.hotel.model.entity.Reservation;
import com.app.hotel.model.request.CreateReservationRequest;
import com.app.hotel.model.response.CreateReservationResponse;
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
}
