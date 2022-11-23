package com.alerouge.demo.codewars;

import java.util.Arrays;

public class OddOrEven {
    public static String oddOrEven (int[] array) {
        int sum = Arrays.stream(array)
                .reduce(0, Integer::sum);
        return sum % 2 == 0 ? "even" : "odd";
    }
}
