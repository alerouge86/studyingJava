package com.alerouge.demo.codewars;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        // getting all the chars count
        Map<Integer, Long> countStr1 = str1.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), counting()));
        Map<Integer, Long> countStr2 = str2.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), counting()));
        // remove all chars not used in str2
        countStr1.keySet().retainAll(countStr2.keySet());
        // the map 2 must have same size and no chars which the occurrences number is greater than the one in map 1
        return countStr2.size() == countStr1.size()
                &&
                countStr2.entrySet().stream().noneMatch(e -> e.getValue() > countStr1.get(e.getKey()));
    }
}
