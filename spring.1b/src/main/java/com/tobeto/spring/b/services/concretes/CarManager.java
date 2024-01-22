package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Car;
import com.tobeto.spring.b.repositories.CarRepository;
import com.tobeto.spring.b.services.abstracts.CarService;
import com.tobeto.spring.b.services.dtos.requests.car.AddCarRequest;
import com.tobeto.spring.b.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.spring.b.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetCarListResponse> responseList = new ArrayList<>();

        for (Car car : cars) {
            GetCarListResponse response = new GetCarListResponse();
            response.setId(car.getId());
            response.setPlate(car.getPlateNumber());
            response.setColor(car.getColor());
            response.setRentalPrice(car.getRentalPrice());
        }
        return responseList;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = carRepository.findById(id).orElseThrow();

        GetCarResponse response = new GetCarResponse();
        response.setPlate(car.getPlateNumber());
        response.setColor(car.getColor());
        response.setRentalPrice(car.getRentalPrice());

        return response;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setPlateNumber(request.getPlate());
        car.setColor(request.getColor());

        car.setRentalPrice  (request.getRentalPrice());
        carRepository.save(car);
    }

    @Override
    public void update(int id, UpdateCarRequest updateCarRequest) {
        Car car = new Car();
        carRepository.findById(id).orElseThrow();
        car.setId(updateCarRequest.getId());
        car.setPlateNumber(updateCarRequest.getPlate());
        car.setColor(updateCarRequest.getColor());
        car.setRentalPrice(updateCarRequest.getRentalPrice());
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }
}

