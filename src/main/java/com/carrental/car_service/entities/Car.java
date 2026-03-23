package com.carrental.car_service.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Car {

    private Long id;

    private String brand;

    private String model;

    private String licensePlate;

    private int carYear;

    private String color;

    private BigDecimal dailyPrice;

}
