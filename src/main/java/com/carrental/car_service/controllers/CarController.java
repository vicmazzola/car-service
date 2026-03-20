package com.carrental.car_service.controllers;

import com.carrental.car_service.entities.Car;
import com.carrental.car_service.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    // http://localhost:8080/cars?page=1&&size=10

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/cars");

        var cars = this.carService.findAllCars(page, size);

        return ResponseEntity.ok(cars);
    }

    // http://localhost:8080/cars/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> findCar(
            @PathVariable("id") Long id
    ) {
        logger.info("/cars/" + id);

        var car = this.carService.findCarById(id);

        return ResponseEntity.ok(car);
    }

}
