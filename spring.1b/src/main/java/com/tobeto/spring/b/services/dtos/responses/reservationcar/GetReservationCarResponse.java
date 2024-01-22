package com.tobeto.spring.b.services.dtos.responses.reservationcar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationCarResponse {
    private String startDate;
    private String endDate;
    private int carId;
    private String agreement;
    private int customerId;
}
