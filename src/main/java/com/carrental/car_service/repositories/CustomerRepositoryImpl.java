package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Customer;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcClient jdbcClient;

    public CustomerRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM customers WHERE id = :id")
                .param("id", id)
                .query(Customer.class)
                .optional();
    }

    @Override
    public List<Customer> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM customers LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Customer.class)
                .list();
    }

    @Override
    public Integer save(Customer customer) {
        return this.jdbcClient
                .sql("INSERT INTO customers (name, cpf, phone, email) VALUES (:name, :cpf, :phone, :email)")
                .param("name", customer.getName())
                .param("cpf", customer.getCpf())
                .param("phone", customer.getPhone())
                .param("email", customer.getEmail())
                .update();
    }

    @Override
    public Integer update(Customer customer, Long id) {
        return this.jdbcClient
                .sql("UPDATE customers SET name = :name, cpf = :cpf, phone = :phone, email = :email WHERE id = :id")
                .param("id", id)
                .param("name", customer.getName())
                .param("cpf", customer.getCpf())
                .param("phone", customer.getPhone())
                .param("email", customer.getEmail())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM customers WHERE id = :id")
                .param("id", id)
                .update();
    }
}
