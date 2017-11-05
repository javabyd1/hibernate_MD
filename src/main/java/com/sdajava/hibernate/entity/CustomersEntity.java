package com.sdajava.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customer_id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String lastname;

    @Column(name = "miasto")
    private String city;
}
