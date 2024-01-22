package com.tobeto.spring.b.services.dtos.requests.reservationcar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationCarRequest {
    private String startDate;
    private String endDate;
    private int carId;
    private String agreement;
    private int customerId;

}
