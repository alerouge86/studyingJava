package com.alerouge.demo.stream.exercises.blogdevgenius.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
public class Order {
    private Long id;

    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;

    private Customer customer;

    @ToString.Exclude
    Set<Product> products;

}


