package com.alerouge.demo.codewars;

import java.util.ArrayList;
import java.util.List;

public class DeadFish {
    public static int[] parse(String data) {
        int value = 0;
        List<Integer> result = new ArrayList<>();
        for (char ch : data.toCharArray()) {
            switch (ch) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value *= value;
                case 'o' -> result.add(value);
                default -> throw new UnsupportedOperationException("command not handled");
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
