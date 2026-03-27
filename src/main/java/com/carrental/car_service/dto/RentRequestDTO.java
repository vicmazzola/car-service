package com.carrental.car_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RentRequestDTO(
        Long customerId,
        Long carId,
        LocalDate initialDate,
        LocalDate endDate
) {
}
