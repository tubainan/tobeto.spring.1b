package com.tobeto.spring.b.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private String plate;
    private double rentalPrice;
    private String color;
    private int brandId;
    private int modelId;

}
