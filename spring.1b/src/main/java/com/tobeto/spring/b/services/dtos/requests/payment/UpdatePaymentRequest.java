package com.tobeto.spring.b.services.dtos.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private int id;
    private String paymentMethod;
    private int paymentAmount;
    private String cardNumber;
    private String validThru;
    private int cvcNumber;
    private String contract;
    private int reservationCarId;
}
