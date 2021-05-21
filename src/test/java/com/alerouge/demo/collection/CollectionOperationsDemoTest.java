package com.alerouge.demo.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionOperationsDemoTest {

    List<String> list;

    @BeforeEach
    void beforeAll() {
        list = Arrays.asList("one", "two", "three", "four", "five");
    }

    @Test
    void parallelStreams() {
//        System.out.println("list = " + list);
        list.forEach(System.out::println);
        System.out.println("");
        list.parallelStream().forEach(System.out::println);
    }

    @Test
    void sorting() {
        Integer[] array = {4, 3, 5, 1, 2};
//        showArray(array);
//        System.out.println("");
//        Arrays.sort(array);
//        showArray(array);
        Arrays.sort(array, 1, 3);
        showArray(array);
    }
    private void showArray(Integer[] array) {
        Arrays.stream(array)
                .map(s -> s + " ")
                .forEach(System.out::print);
    }

}