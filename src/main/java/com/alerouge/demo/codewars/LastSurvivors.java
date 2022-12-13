package com.alerouge.demo.codewars;

import java.util.HashMap;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class LastSurvivors {
    public static String lastSurvivors(String str) {
        // mapping the chars occurrences
        Map<Integer, Long> mapOccurrences = str.chars()
                .boxed()
                .collect(groupingBy(identity(), counting()));
        // transforming the map
        Map<Integer, Long> mapTransformed = new HashMap<>();
        for (Map.Entry<Integer, Long> entry : mapOccurrences.entrySet()) {
            int key = entry.getKey();
            long value = entry.getValue();
            if (value > 1) {
                int newKey = key == 'z' ? 'a' : key + 1;
                mapTransformed.merge(newKey, value / 2, Long::sum);
                if (value % 2 != 0) {
                    mapTransformed.merge(key, 1L, Long::sum);
                }
            } else {
                mapTransformed.merge(key, value, Long::sum);
            }
        }
        // converting in string
        String newStr = mapTransformed.entrySet().stream()
                .map(entry -> String.valueOf((char) entry.getKey().intValue()).repeat(Math.toIntExact(entry.getValue())))
                .collect(joining());
        // checking if contains only one occurrences
        boolean onlyOneOccurrences = newStr.chars()
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .noneMatch(entry -> entry.getValue() > 1);
        // recursive condition
        if (onlyOneOccurrences) {
            return newStr;
        } else {
            return lastSurvivors(newStr);
        }
    }
}
