package com.alerouge.demo.collection.map.operations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MapNewMethodsJava8Test {

    @Test
    void computeTest() {

        Map<Integer, String> map = new HashMap<>(Map.of(1, "one", 3, "three", 5, "five"));

        System.out.println("the original map:");
        map.forEach((k, v) -> System.out.printf("for the key %d the value is %s%n", k, v) );

        final String appendixString = "_addedToString";

        IntStream.rangeClosed(1, 10)
                .boxed()
                .forEach(i -> map.compute(i, (k, v) -> v == null ? appendixString : v.concat(appendixString)));

        System.out.println("\nthe modified one:");
        map.forEach((k, v) -> System.out.printf("for the key %d the value is %s%n", k, v) );
    }

    @Test
    void computeIfAbsentTest() {
        Map<Integer, List<String>> map = IntStream.rangeClosed(0, 10)
                .boxed()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toMap(i -> i, this::createList));

        System.out.println("the original map:");
        map.forEach((k, v) -> System.out.printf("for the key %d the value is %s%n", k, v) );

        map.computeIfAbsent(1, k -> initializeArray()).add("99");
        map.computeIfAbsent(2, k -> initializeArray()).add("99");

        System.out.println("\nthe modified one:");
        map.forEach((k, v) -> System.out.printf("for the key %d the value is %s%n", k, v) );
    }

    private List<String> initializeArray() {
        System.out.println("initializeArray called");
        return new ArrayList<>();
    }

    private List<String> createList(int i) {
        return IntStream.rangeClosed(1, i)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
