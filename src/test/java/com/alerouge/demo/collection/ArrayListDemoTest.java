package com.alerouge.demo.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static java.util.stream.Collectors.*;

class ArrayListDemoTest {

    @Test
    void createArrayList() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }
    @Test
    void createArrayListWithSize() {
        List<String> list = new ArrayList<>(10);
        System.out.println("is empty: " + list.isEmpty());
        System.out.println("size: " + list.size());
        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);
    }
    @Test
    void createArrayListFromCollection() {
        Collection<Integer> numbers = IntStream.range(0, 10).boxed()
                .collect(toSet());
        List<Integer> list = new ArrayList<>(numbers);
        assertEquals(10, list.size());
        assertTrue(numbers.containsAll(list));
        assertTrue(list.containsAll(numbers));
    }
    @Test
    void createArrayListFromCollection2() {
        List<Integer> list = IntStream.range(0, 10).boxed()
                .collect(toList());
        list.forEach(System.out::println);
    }

}