package com.alerouge.demo.stream.exercises.blogdevgenius.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@NoArgsConstructor
public class Product {
    private Long id;

    private String name;
    private String category;
    private Double price;

    @ToString.Exclude
    private Set<Order> orders;
}