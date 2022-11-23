package com.alerouge.demo.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {
    public static int findIt(int[] a) {
        return Arrays.stream(a)
                .reduce(0, (x, y) -> x ^ y);
    }

    public static int findIt_myVersion(int[] a) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow();
    }
}
