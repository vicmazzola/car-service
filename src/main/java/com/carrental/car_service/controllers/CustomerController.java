package com.carrental.car_service.controllers;

import com.carrental.car_service.entities.Customer;
import com.carrental.car_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    // http://localhost:8080/customers?page=1&&size=10

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        logger.info("/customers");

        var customers = this.customerService.findAllCustomers(page, size);

        return ResponseEntity.ok(customers);
    }

    // http://localhost:8080/customers/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> findCustomer(@PathVariable("id") Long id) {
        logger.info("/customers/" + id);

        var customer = this.customerService.findCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer) {
        logger.info("POST -> /customers/");

        this.customerService.saveCustomer(customer);

        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer
    ) {

        logger.info("PUT -> /customers/" + id);

        this.customerService.updateCustomer(customer, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {

        logger.info("DELETE -> /customers/" + id);

        this.customerService.delete(id);

        return ResponseEntity.ok().build();
    }


}
