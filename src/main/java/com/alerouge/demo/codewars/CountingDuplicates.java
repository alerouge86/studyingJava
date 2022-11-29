package com.alerouge.demo.codewars;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * Count the number of Duplicates
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.
 * The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
 * <p>
 * Example
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<Character, Long> charCount = text.toLowerCase()
                .chars()
                .mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), counting()));

        long result = charCount.values()
                .stream()
                .filter(i -> i > 1)
                .count();

        return (int) result;
    }
}
