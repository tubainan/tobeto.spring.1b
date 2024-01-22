package com.tobeto.spring.b.controllers;

import com.tobeto.spring.b.services.abstracts.CustomerService;
import com.tobeto.spring.b.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.spring.b.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.spring.b.services.dtos.responses.customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerService customerService;


    @GetMapping
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest addCustomerRequest){
        customerService.add(addCustomerRequest);
    }


    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.update(updateCustomerRequest);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }
}
