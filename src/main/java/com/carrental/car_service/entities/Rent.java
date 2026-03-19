package com.carrental.car_service.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Rent {

    private Long id;

    private Long customerId;

    private Long carId;

    private String carModel;

    private String customerCpf;

    private String customerName;

    private LocalDate initialDate;

    private LocalDate endDate;

    private BigDecimal totalValue;


}
