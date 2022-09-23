package com.app.hotel.controller;

import com.app.hotel.exception.ReservationAlreadyDoneException;
import com.app.hotel.model.request.CreateReservationRequest;
import com.app.hotel.model.response.CreateReservationResponse;
import com.app.hotel.model.response.GetReservationResponse;
import com.app.hotel.service.CreateReservationImpl;
import com.app.hotel.service.GetAllReservationImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

  private final CreateReservationImpl createReservation;

  private final GetAllReservationImpl getAllReservation;

  @Autowired
  public ReservationController(CreateReservationImpl createReservation,
      GetAllReservationImpl getAllReservation) {
    this.createReservation = createReservation;
    this.getAllReservation = getAllReservation;
  }

  @PostMapping("/create")
  public ResponseEntity<CreateReservationResponse> create(@Valid @RequestBody
  CreateReservationRequest request) throws ReservationAlreadyDoneException {
    CreateReservationResponse response = createReservation.createReservation(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/getAll")
  public ResponseEntity<GetReservationResponse> getAll() {
    GetReservationResponse getReservationResponse = getAllReservation.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(getReservationResponse);
  }
}
