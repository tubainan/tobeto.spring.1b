package com.tobeto.spring.b.services.dtos.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String surName;
    private String phoneNumber;
    private String identityNumber;
    private String email;
    private String adress;
}
