package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Customer;
import com.tobeto.spring.b.entities.Model;
import com.tobeto.spring.b.repositories.ModelRepository;
import com.tobeto.spring.b.services.abstracts.ModelService;
import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager  implements ModelService {

    private final ModelRepository modelRepository;


    @Override
    public List<GetCustomerListResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetCustomerListResponse> responseList = new ArrayList<>();

        for (Customer customer : customers) {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getName());
            response.setYear(customer.getYear());

        }
        return responseList;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        GetCustomerResponse response = new GetCustomerResponse();
        response.setName(customer.getName());
        response.setYear(customer.getYear());

        return response;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setYear(request.getYear());

        customerRepository.save(customer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = new Customer();
        customerRepository.findById(id).orElseThrow();
        customer.setId(updateCustomerRequest.getId());
        customer.setName(updateCustomerRequest.getName());
        customer.setYear(updateCustomerRequest.getYear());

        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }
}