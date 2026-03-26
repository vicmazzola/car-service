package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Customer;
import com.carrental.car_service.entities.Rent;

import java.util.List;
import java.util.Optional;

public interface RentRepository {
    Optional<Rent> findById(Long id);

    List<Rent> findAll(int size, int offset);

    Integer save(Rent rent);

    Integer update(Rent rent, Long id);

    Integer delete(Long id);

}
