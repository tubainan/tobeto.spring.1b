package com.tobeto.spring.b.services.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private String paymentMethod;
    private int paymentAmount;
    private String cardNumber;
    private String validThru;
    private int cvcNumber;
    private String contract;
    private int reservationCarId;
}
