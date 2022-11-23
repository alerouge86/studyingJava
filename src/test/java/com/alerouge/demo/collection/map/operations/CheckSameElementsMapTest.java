package com.alerouge.demo.collection.map.operations;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

class CheckSameElementsMapTest {

    @Test
    void givenTwoMap_thenReturnTheIndexesOfSecondMapWhereTheExactElementsOccur() {

        Map<Integer, String> map1 = Map.of(1, "a", 2, "b", 3, "c", 4, "d", 5, "e", 6, "f");
        Map<Integer, String> map2 = Map.of(1, "a", 2, "bb", 3, "c", 4, "dd", 5, "e", 6, "ff");

//        printMap(map1);
//        System.out.println("");
//        printMap(map2);


        HashSet<String> valuesMap1 = new HashSet<>(map1.values());
        Set<Integer> result = map2.entrySet().stream()
                .filter(entry -> valuesMap1.contains(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(toSet());
        result.forEach(System.out::println);


        assertThat(result).containsAll(Set.of(1, 3, 5));
    }

    @Test
    void givenTwoMap_thenReturnTheIndexesOfSecondMapWhereTheExactElementsOccur_withoutStream() {

        Map<Integer, String> map1 = Map.of(1, "a", 2, "b", 3, "c", 4, "d", 5, "e", 6, "f");
        Map<Integer, String> map2 = Map.of(1, "a", 2, "bb", 3, "c", 4, "dd", 5, "e", 6, "ff");

//        printMap(map1);
//        System.out.println("");
//        printMap(map2);



        HashSet<String> valuesMap1 = new HashSet<>(map1.values());
        Map<Integer, String> copyMap2 = new HashMap<>(map2);

//        valuesMap1.forEach(System.out::println);
//        System.out.println("before\n");
//        printMap(copyMap2);

        copyMap2.values().retainAll(valuesMap1);

        Set<Integer> result = copyMap2.keySet();
        result.forEach(System.out::println);


//        System.out.println("after\n");
//        printMap(copyMap2);


        assertThat(result).containsAll(Set.of(1, 3, 5));
    }

    private void printMap(Map<Integer, String> map) {
        map.forEach((k, v) -> System.out.printf("key:%s - value:%s%n", k, v));
    }
}
