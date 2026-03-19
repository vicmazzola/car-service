package com.carrental.car_service.repositories;

import com.carrental.car_service.entities.Car;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final JdbcClient jdbcClient;

    public CarRepositoryImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Car> findAll(int size, int offset) {
        return List.of();
    }

    @Override
    public Integer save(Car car) {
        return 0;
    }

    @Override
    public Integer update(Car car, Long id) {
        return 0;
    }

    @Override
    public Integer delete(Long id) {
        return 0;
    }
}
