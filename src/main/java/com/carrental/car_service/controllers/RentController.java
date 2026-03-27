package com.carrental.car_service.controllers;

import com.carrental.car_service.dto.RentRequestDTO;
import com.carrental.car_service.entities.Rent;
import com.carrental.car_service.service.RentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/rents")
public class RentController {

    private static final Logger logger = LoggerFactory.getLogger(RentController.class);

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }


    // http://localhost:8080/rent?page=1&&size=10

    @GetMapping
    public ResponseEntity<List<Rent>> findAllRents(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/rent");

        var rent = this.rentService.findAllRents(page, size);

        return ResponseEntity.ok(rent);
    }

    // http://localhost:8080/rent/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rent>> findRent(@PathVariable("id") Long id) {
        logger.info("/rent/" + id);

        var rent = this.rentService.findRentById(id);

        return ResponseEntity.ok(rent);
    }

    @PostMapping
    public ResponseEntity<Void> saveRent(@Valid @RequestBody RentRequestDTO rent) {
        logger.info("POST -> /rent/");

        this.rentService.saveRent(rent);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRent(
            @PathVariable("id") Long id,
            @RequestBody Rent rent
    ) {

        logger.info("PUT -> /rent/" + id);

        this.rentService.updateRent(rent, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable("id") Long id) {

        logger.info("DELETE -> /rent/" + id);

        this.rentService.delete(id);

        return ResponseEntity.ok().build();
    }


}
