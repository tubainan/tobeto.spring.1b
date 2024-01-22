package com.tobeto.spring.b.controllers;


import com.tobeto.spring.b.services.abstracts.ReservationCarService;
import com.tobeto.spring.b.services.dtos.requests.reservationcar.AddReservationCarRequest;
import com.tobeto.spring.b.services.dtos.requests.reservationcar.UpdateReservationCarRequest;
import com.tobeto.spring.b.services.dtos.responses.reservationcar.GetReservationCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.reservationcar.GetReservationCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservationcars")
@AllArgsConstructor
public class ReservationCarsController {

    private final ReservationCarService reservationCarService;

    @GetMapping
    public List<GetReservationCarListResponse> getAll(){
        return reservationCarService.getAll();
    }

    @GetMapping("{id}")
    public GetReservationCarResponse getById(@PathVariable int id){
        return reservationCarService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddReservationCarRequest addReservationCarRequest){
        reservationCarService.add(addReservationCarRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateReservationCarRequest updateReservationCarRequest){
        reservationCarService.update(updateReservationCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        reservationCarService.delete(id);
    }

}
