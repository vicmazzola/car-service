package com.carrental.car_service.entities;

import com.carrental.car_service.dto.RentRequestDTO;
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

    public Rent(RentRequestDTO dto, BigDecimal value) {
        this.customerId = dto.customerId();
        this.carId = dto.carId();
        this.initialDate = dto.initialDate();
        this.endDate = dto.endDate();
        this.totalValue = value;
    }


}
