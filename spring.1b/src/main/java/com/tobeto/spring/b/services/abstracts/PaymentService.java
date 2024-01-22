package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.requests.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentListResponse;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentResponse;

import java.util.List;

public interface PaymentService {
    List<GetPaymentListResponse> getAll();
    GetPaymentResponse getById(int id);
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest updatePaymentRequest);
    void delete(int id);

}
