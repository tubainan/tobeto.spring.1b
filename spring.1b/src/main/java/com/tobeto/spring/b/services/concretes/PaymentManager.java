package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Payment;
import com.tobeto.spring.b.repositories.PaymentRepository;
import com.tobeto.spring.b.services.abstracts.ModelService;
import com.tobeto.spring.b.services.abstracts.PaymentService;
import com.tobeto.spring.b.services.dtos.requests.payment.AddPaymentRequest;
import com.tobeto.spring.b.services.dtos.requests.payment.UpdatePaymentRequest;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentListResponse;
import com.tobeto.spring.b.services.dtos.responses.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setPhone(customer.getPhone());
            response.setEmail(customer.getEmail());
            response.setAddress(customer.getAddress());
            response.setCarLicense(customer.getCarLicense());
            response.setPhone(customer.getPhone());
        }
        return responseList;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse response = new GetCustomerResponse();
        response.setName(customer.getName());
        response.setPhone(customer.getPhone());
        response.setEmail(customer.getEmail());
        response.setAddress(customer.getAddress());
        response.setCarLicense(customer.getCarLicense());
        response.setPhone(customer.getPhone());
        return response;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setCarLicense(request.getCarLicense());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = new Customer();
        customerRepository.findById(id).orElseThrow();
        customer.setId(updateCustomerRequest.getId());
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setPhone(updateCustomerRequest.getPhone());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setCarLicense(updateCustomerRequest.getCarLicense());
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}