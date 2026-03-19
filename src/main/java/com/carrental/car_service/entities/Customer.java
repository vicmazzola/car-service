package com.carrental.car_service.entities;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

    private Long id;

    private String name;

    private String cpf;

    private String phone;

    private String email;


}
