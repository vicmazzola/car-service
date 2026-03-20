package com.carrental.car_service.service;

import com.carrental.car_service.entities.Car;
import com.carrental.car_service.repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars(int page, int size) {
        int offset = (page - 1) * size;
        return carRepository.findAll(size, offset);
    }

    public Optional<Car> findCarById(Long id) {
        return this.carRepository.findById(id);
    }

    public void saveCar(Car car) {
        var save = this.carRepository.save(car);
        Assert.state(save == 1, "Error when trying to save car " + car.getModel());
    }

    public void updateCar(Car car, Long id) {
        var update = this.carRepository.update(car, id);

        if (update == 0) {
            throw new RuntimeException("Car not found");
        }

    }

    public void delete(Long id) {
        var delete = this.carRepository.delete(id);

        if (delete == 0) {
            throw new RuntimeException("Car not found");
        }
    }
}
