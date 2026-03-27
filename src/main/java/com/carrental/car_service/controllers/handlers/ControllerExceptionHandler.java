package com.carrental.car_service.controllers.handlers;

import com.carrental.car_service.dto.ResourceNotFoundDto;
import com.carrental.car_service.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status.value()).body(new ResourceNotFoundDto(e.getMessage(), status.value()));
    }

}
