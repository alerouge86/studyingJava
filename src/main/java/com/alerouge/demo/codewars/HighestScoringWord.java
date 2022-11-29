package com.alerouge.demo.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Given a string of words, you need to find the highest scoring word.
 *
 * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
 *
 * You need to return the highest scoring word as a string.
 *
 * If two words score the same, return the word that appears earliest in the original string.
 *
 * All letters will be lowercase and all inputs will be valid.
 */
public class HighestScoringWord {
    public static String high(String s) {

        Map<Integer, List<String>> mapWordScores = Arrays.stream(s.split(" "))
                .collect(groupingBy(w -> w.chars().map(i -> i - 96).sum()));

        List<String> stringList = mapWordScores.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow();

        return stringList.get(0);
    }

}
