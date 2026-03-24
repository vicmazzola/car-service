package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository {


    Optional<Customer> findById(Long id);

    List<Customer> findAll(int size, int offset);

    Integer save(Customer customer);

    Integer update(Customer customer, Long id);

    Integer delete(Long id);

}
