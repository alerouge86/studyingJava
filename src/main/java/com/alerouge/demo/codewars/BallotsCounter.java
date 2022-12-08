package com.alerouge.demo.codewars;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class BallotsCounter {
    public static String getWinner(final List<String> listOfBallots) {
        Map<String, Long> mapCount = listOfBallots.stream()
                .collect(groupingBy(Function.identity(), counting()));
        String possibleWinner = mapCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        if (possibleWinner != null) {
            return mapCount.get(possibleWinner) > listOfBallots.size() / 2 ? possibleWinner : null;
        } else {
            return null;
        }
    }
}
