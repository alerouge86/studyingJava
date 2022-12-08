package com.alerouge.demo.codewars;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * To participate in a prize draw each one gives his/her firstname.
 * <p>
 * Each letter of a firstname has a value which is its rank in the English alphabet. A and a have rank 1, B and b rank 2 and so on.
 * <p>
 * The length of the firstname is added to the sum of these ranks hence a number som.
 * <p>
 * An array of random weights is linked to the firstnames and each som is multiplied by its corresponding weight to get what they call a winning number.
 * <p>
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * <p>
 * PauL -> som = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54
 * The *weight* associated with PauL is 2 so PauL's *winning number* is 54 * 2 = 108.
 * Now one can sort the firstnames in decreasing order of the winning numbers. When two people have the same winning number sort them alphabetically by their firstnames.
 * <p>
 * Task:
 * parameters: st a string of firstnames, we an array of weights, n a rank
 * <p>
 * return: the firstname of the participant whose rank is n (ranks are numbered from 1)
 * <p>
 * Example:
 * names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
 * weights: [1, 4, 4, 5, 2, 1]
 * n: 4
 * <p>
 * The function should return: "PauL"
 * Notes:
 * The weight array is at least as long as the number of names, it may be longer.
 * <p>
 * If st is empty return "No participants".
 * <p>
 * If n is greater than the number of participants then return "Not enough participants".
 * <p>
 * See Examples Test Cases for more examples.
 */
public class PrizeDraw {
    private static final int INDEX_UPPERCASE = 64;
    private static final int INDEX_LOWERCASE = 96;

    public static String nthRank(String st, Integer[] we, int n) {
        if (st == null || st.isEmpty()) return "No participants";
        String[] names = st.split(",");
        if (n > names.length) return "Not enough participants";

        Map<String, Integer> mapWinningNumber = IntStream.range(0, names.length)
                .boxed()
                .collect(Collectors.toMap(i -> names[i], i -> countWinningNumber(names[i].trim(), i, we)));
        // ordering by values (winning numbers) and then alphabetically
        Comparator<Map.Entry<String, Integer>> comparatorValues = Map.Entry.comparingByValue();
        Comparator<Map.Entry<String, Integer>> comparatorKeys = Map.Entry.comparingByKey();
        List<String> winningNumberOrdered = mapWinningNumber.entrySet().stream()
                .sorted(Collections.reverseOrder(comparatorValues).thenComparing(comparatorKeys))
                .map(Map.Entry::getKey)
                .toList();
        return winningNumberOrdered.get(n - 1);
    }


    private static int countWinningNumber(String name, int index, Integer[] we) {
        return (name.length() + name.chars()
                .map(c -> c - ((c > INDEX_LOWERCASE) ? INDEX_LOWERCASE : INDEX_UPPERCASE))
                .sum()) * we[index];
    }
}
