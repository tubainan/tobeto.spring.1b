package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.ReservationCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationCarRepository extends JpaRepository<ReservationCar,Integer> {
}
