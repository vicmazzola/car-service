package com.carrental.car_service.dto;

import java.util.List;

public record ValidationErrorDto(List<String> errors, int status) {
}
