package com.app.hotel.service;

import com.app.hotel.exception.ReservationAlreadyDoneException;
import com.app.hotel.mapper.MapperReservation;
import com.app.hotel.model.entity.Guest;
import com.app.hotel.model.entity.Reservation;
import com.app.hotel.model.request.CreateReservationRequest;
import com.app.hotel.model.response.CreateReservationResponse;
import com.app.hotel.repository.GuestRepository;
import com.app.hotel.repository.ReservationRepository;
import com.app.hotel.service.abstraction.CreateReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateReservationImpl implements CreateReservation {

  private final ReservationRepository reservationRepository;

  private final GuestRepository guestRepository;

  private final MapperReservation mapperReservation;

  @Autowired
  public CreateReservationImpl(ReservationRepository reservationRepository,
      GuestRepository guestRepository, MapperReservation mapperReservation) {
    this.reservationRepository = reservationRepository;
    this.guestRepository = guestRepository;
    this.mapperReservation = mapperReservation;
  }
  // TODO: Fix problem with pay attribute
  @Override
  public CreateReservationResponse createReservation(CreateReservationRequest request)
      throws ReservationAlreadyDoneException {

    if (reservationRepository.
        existsReservationByReservationFromDateAndReservationToDate(request.getReservationFromDate(),
            request.getReservationToDate())) {
      throw new ReservationAlreadyDoneException("Reservation already done");
    }

    String email = SecurityContextHolder.getContext().getAuthentication().getName();

    Guest guest = guestRepository.findGuestByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    Reservation reservation = mapperReservation.map(request);
    reservation.setPay(1234456L);
    reservation.setGuest(guest);

    return mapperReservation.map(reservationRepository.save(reservation));
  }
}
