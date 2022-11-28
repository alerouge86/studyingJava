package com.alerouge.demo.codewars;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {
        if (numberInteresting(number, awesomePhrases)) {
            return 2;
        } else if (numberInteresting(number + 1, awesomePhrases) || numberInteresting(number + 2, awesomePhrases)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean numberInteresting(int number, int[] awesomePhrases) {

        String numberStr = String.valueOf(number);
        if (numberStr.length() < 3) return false;

        return new StringBuilder(numberStr).reverse().toString().equals(numberStr) || // palindrome
                Arrays.stream(awesomePhrases).anyMatch(n -> n == number) || // awesome array
                isAllSameDigit(numberStr) || // same digits
                numberStr.contains("0") && isAllSameDigit(numberStr.substring(1)) || // followed by zeros
                isSequential(numberStr, false) || // sequential positive
                isSequential(numberStr, true); // sequential positive
    }

    private static boolean isSequential(String numberStr, boolean negative) {
        int incrementDecrement = negative ? -1 : 1;
        for (int i = 0; i < numberStr.length(); i++) {
            if (i + 1 < numberStr.length()) {
                boolean check = (!negative && numberStr.charAt(i) == '9' && numberStr.charAt(i + 1) == '0')
                        ||
                        (negative && numberStr.charAt(i) == '1' && numberStr.charAt(i + 1) == '0')
                        ||
                        (numberStr.charAt(i) + incrementDecrement == numberStr.charAt(i + 1));
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAllSameDigit(String numberStr) {
        return numberStr.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .size() == 1;
    }
}
