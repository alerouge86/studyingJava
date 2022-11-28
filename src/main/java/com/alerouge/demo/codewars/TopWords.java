package com.alerouge.demo.codewars;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TopWords {
    public static List<String> top3(String s) {

            // checking if string contains at leas one word
            Pattern pattern = Pattern.compile("\\w", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(s);
            if (!matcher.find()) return Collections.emptyList();

            // removing all chars except letters and "'"
            s = s.replaceAll("[^\\w' ]", "");

            // grouping letters by counting
            Map<String, Long> mapCounting = Arrays.stream(s.split(" "))
                    .filter(str -> !str.isEmpty())
                    .map(String::toLowerCase)
                    .collect(groupingBy(Function.identity(), counting()));

            // taking the first 3 in reverse order
            return mapCounting.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .toList();
        }
}
