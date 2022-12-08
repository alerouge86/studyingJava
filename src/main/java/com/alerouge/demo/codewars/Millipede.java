package com.alerouge.demo.codewars;

import java.util.*;
import static java.util.stream.Collectors.*;

/**
 * The set of words is given. Words are joined if the last letter of one word and the first letter of another word are the same.
 * Return true if all words of the set can be combined into one word. Each word can and must be used only once. Otherwise return false.
 *
 * Input
 * Array of 3 to 7 words of random length. No capital letters.
 *
 * Example true
 * Set: excavate, endure, desire, screen, theater, excess, night.
 * Millipede: desirE EndurE ExcavatE ExcesS ScreeN NighT Theater.
 *
 * Example false
 * Set: trade, pole, view, grave, ladder, mushroom, president.
 * Millipede: presidenT Trade.
 */
public class Millipede {
    public static boolean check(String[] millipede) {
        for (String word : millipede) {
            List<String> listWithoutWord = Arrays.stream(millipede)
                    .filter(w -> !w.equals(word))
                    .toList();
            if (checkMatches(word, listWithoutWord)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMatches(String word, List<String> listWithoutWord) {
        List<String> listTest = new ArrayList<>();

        listTest.add(word);







        return false;
    }
}


/**

 // grouping for first letters
 Map<String, Long> mapFirstLetters = Arrays.stream(millipede)
 .collect(groupingBy(w -> w.substring(0, 1), counting()));

 // grouping for last letters
 Map<String, Long> mapLastLetters = Arrays.stream(millipede)
 .collect(groupingBy(w -> w.substring(w.length() - 1), counting()));

 // merging the maps
 Map<String, Long> mapMerged = new HashMap<>(mapFirstLetters);
 mapLastLetters.forEach(
 (k, v) -> mapMerged.merge(k, v, (v1, v2) -> v1 + v2)
 );

 return mapMerged.values().stream()
 .filter(v -> v % 2 == 0)
 .count() >= millipede.length - 1;


 */