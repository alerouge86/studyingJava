package com.alerouge.demo.codewars;


import java.util.*;

public class Kata {
    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(w -> present(w, array2))
                .sorted()
                .toArray(String[]::new);
    }
    private static boolean present(String word, String[] array2) {
        return Arrays.stream(array2).anyMatch(w -> w.contains(word));
    }
}
