package com.tobeto.spring.b.services.concretes;


import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.repositories.CustomerRepository;

import com.tobeto.spring.b.services.abstracts.CustomerService;
import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setSurName(customer.getSurName());
            response.setPhoneNumber(customer.getPhoneNumber());
            response.setIdentityNumber(customer.getIdentityNumber());
            response.setEmail(customer.getEmail());
            response.setAdress(customer.getAdress());

        }
        return responseList;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse response = new GetCustomerResponse();
        response.setName(customer.getName());
        response.setSurName(customer.getSurName());
        response.setPhoneNumber(customer.getPhoneNumber());
        response.setIdentityNumber(customer.getIdentityNumber());
        response.setEmail(customer.getEmail());
        response.setAdress(customer.getAdress());

        return response;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setSurName(request.getSurName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setIdentityNumber(request.getIdentityNumber());
        customer.setEmail(request.getEmail());
        customer.setAdress(request.getAdress());

        customerRepository.save(customer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = new Customer();
        customerRepository.findById(id).orElseThrow();
        customer.setId(updateCustomerRequest.getId());
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurName());
        customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
        customer.IdentityNumber(updateCustomerRequest.getIdentityNumber());
        customer.setEmail(updateCustomerRequest.getEmail());
        customer.setAdress(updateCustomerRequest.getAdress());

        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}
}
