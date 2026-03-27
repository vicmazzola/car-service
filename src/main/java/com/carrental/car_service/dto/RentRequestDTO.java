package com.carrental.car_service.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public record RentRequestDTO(
        @NotNull(message = "Customer ID can't be null")
        Long customerId,

        @NotNull(message = "Car ID can't be null")
        Long carId,
        LocalDate initialDate,
        LocalDate endDate
) {
}
