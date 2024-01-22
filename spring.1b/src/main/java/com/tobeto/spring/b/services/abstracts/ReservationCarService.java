package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.reservationcar.AddReservationCarRequest;
import com.tobeto.spring.b.services.dtos.requests.reservationcar.UpdateReservationCarRequest;
import com.tobeto.spring.b.services.dtos.responses.reservationcar.GetReservationCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.reservationcar.GetReservationCarResponse;

import java.util.List;

public interface ReservationCarService {
    List<GetReservationCarListResponse> getAll();
    GetReservationCarResponse getById(int id);
    void add(AddReservationCarRequest request);
    void update(UpdateReservationCarRequest updateReservationCarRequest);
    void delete(int id);

}
