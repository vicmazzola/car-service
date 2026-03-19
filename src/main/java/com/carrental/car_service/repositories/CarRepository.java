package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    Optional<Car> findById(Long id);

    List<Car> findAll(int size, int offset);

    Integer save(Car car);

    Integer update(Car car, Long id);

    Integer delete(Long id);

}
