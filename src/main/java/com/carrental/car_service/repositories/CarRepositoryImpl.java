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
        return this.jdbcClient
                .sql("SELECT * FROM cars WHERE id = :id")
                .param("id", id)
                .query(Car.class)
                .optional();
    }

    @Override
    public List<Car> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM cars LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Car.class)
                .list();
    }

    @Override
    public Integer save(Car car) {
        return this.jdbcClient
                .sql("INSERT INTO cars (brand, model, car_year, color ,daily_price) VALUES (:brand, :model, :car_year, :color ,:daily_price)")
                .param("brand", car.getBrand())
                .param("model", car.getModel())
                .param("car_year", car.getCarYear())
                .param("color", car.getColor())
                .param("daily_price", car.getDailyPrice())
                .update();
    }

    @Override
    public Integer update(Car car, Long id) {
        return this.jdbcClient
                .sql("UPDATE cars SET brand = :brand, model = :model, car_year = :car_year, color = :color, daily_price = :daily_price WHERE id = :id")
                .param("id", id)
                .param("brand", car.getBrand())
                .param("model", car.getModel())
                .param("car_year", car.getCarYear())
                .param("color", car.getColor())
                .param("daily_price", car.getDailyPrice())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM cars WHERE id = :id")
                .param("id", id)
                .update();
    }
}
