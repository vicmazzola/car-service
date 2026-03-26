package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Rent;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RentRepositoryImpl implements RentRepository {

    private final JdbcClient jdbcClient;

    public RentRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Rent> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT r.id, r.customer, r.car_id, r.initial_date, r.end_date, r.total_value, " +
                        "c.name AS customer_name, c.cpf, AS customer_cpf" +
                        "c.model AS car_model FROM rent r " +
                        "INNER JOIN customers c ON r.customer_id = c.id " +
                        "INNER JOIN cars c ON r.car_id = c.id " +
                        "WHERE r.id = :id"
                )
                .param("id", id)
                .query(Rent.class)
                .optional();
    }

    @Override
    public List<Rent> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT r.id, r.customer, r.car_id, r.initial_date, r.end_date, r.total_value, " +
                        "c.name AS customer_name, c.cpf, AS customer_cpf" +
                        "c.model AS car_model FROM rent r " +
                        "INNER JOIN customers c ON r.customer_id = c.id " +
                        "INNER JOIN cars c ON r.car_id = c.id " +
                        "LIMIT :size OFFSET :offset"
                )
                .param("size", size)
                .param("offset", offset)
                .query(Rent.class)
                .list();
    }

    @Override
    public Integer save(Rent rent) {
        return this.jdbcClient
                .sql("INSERT INTO rent (customer_id, car_id, initial_date, end_date, total_value) VALUES (:customer_id, :car_id, :initial_date, :end_date, :total_value)")
                .param("customer_id", rent.getCustomerId())
                .param("car_id", rent.getCarId())
                .param("initial_date", rent.getInitialDate())
                .param("end_date", rent.getEndDate())
                .param("total_value", rent.getTotalValue())
                .update();
    }

    @Override
    public Integer update(Rent rent, Long id) {
        return this.jdbcClient
                .sql("UPDATE rent SET customer_id = :customer_id, car_id = :car_id, initial_date = :initial_date, end_date = :end_date, total_value = :total_value WHERE id = :id")
                .param("customer_id", rent.getCustomerId())
                .param("car_id", rent.getCarId())
                .param("initial_date", rent.getInitialDate())
                .param("end_date", rent.getEndDate())
                .param("total_value", rent.getTotalValue())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM rent WHERE id = :id")
                .param("id", id)
                .update();
    }
}
