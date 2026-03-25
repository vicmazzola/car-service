package com.carrental.car_service.service;

import com.carrental.car_service.entities.Customer;
import com.carrental.car_service.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = CustomerService.this.customerRepository;
    }

    public List<Customer> findAllCustomers(int page, int size) {
        int offset = (page - 1) * size;
        return customerRepository.findAll(size, offset);
    }

    public Optional<Customer> findCustomerById(Long id) {
        return this.customerRepository.findById(id);
    }

    public void saveCustomer(Customer customer) {
        var save = this.customerRepository.save(customer);
        Assert.state(save == 1, "Error when trying to save customer" + customer.getName());
    }

    public void updateCustomer(Customer customer, Long id) {
        var update = this.customerRepository.update(customer, id);

        if (update == 0) {
            throw new RuntimeException("Customer not found");
        }

    }

    public void delete(Long id) {
        var delete = this.customerRepository.delete(id);

        if (delete == 0) {
            throw new RuntimeException("Customer not found");
        }
    }
}
