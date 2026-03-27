package com.carrental.car_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record RentRequestDTO(

        @Schema(description = "Costumer ID that is renting the car")
        @NotNull(message = "Customer ID can't be null")
        Long customerId,

        @NotNull(message = "Car ID can't be null")
        Long carId,
        LocalDate initialDate,
        LocalDate endDate
) {
}
