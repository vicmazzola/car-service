package com.carrental.car_service.dto;

public record ResourceNotFoundDto(
        String message,
        int status
) {
}
