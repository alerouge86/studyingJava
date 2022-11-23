package com.alerouge.demo.codewars.camelcaseconvert;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    static String toCamelCase(String s){

        // split to divide the words in an array
        String[] words = s.split("[-_,.]");

        return Arrays.stream(words, 1, words.length)
                .map(w -> w.substring(0, 1).toUpperCase() + w.substring(1))
                .reduce(words[0], String::concat);
    }

    static String toCamelCase2(String s){

        // split to divide the words in an array
        String[] words = s.split("[-_,.]");
        return IntStream.range(0, words.length)
                .mapToObj(i -> i == 0 ? words[0] : words[i].substring(0, 1).toUpperCase() + words[i].substring(1))
                .collect(Collectors.joining());
    }
}
