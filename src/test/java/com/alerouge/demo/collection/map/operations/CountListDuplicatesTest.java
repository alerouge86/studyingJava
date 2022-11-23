package com.alerouge.demo.collection.map.operations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CountListDuplicatesTest {

    @Test
    void givenTwoHashSet_ThenEqual() {

        HashSet<String> set1 = IntStream.rangeClosed(1, 10)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println("set 1:");
        set1.forEach(System.out::println);

        HashSet<String> set2 = new HashSet<>(Arrays.asList("8", "9", "3", "4", "10", "6", "7", "1", "2", "2"));

        System.out.println("set 2:");
        set2.forEach(System.out::println);

        assertEquals(set1, set2);


    }
}