package com.alerouge.demo.codewars;

import java.util.ArrayList;
import java.util.List;

public class BitCounting {

    public static int countBits2(int n){
        return Integer.bitCount(n);
    }

    public static int countBits(int n){
        String s = Integer.toBinaryString(n);
        System.out.println("s = " + s);

        return Integer.bitCount(n);
    }

    public static int countBits3(int n) {
        // convert decimal to binary
        List<String> binary = new ArrayList<>();
        binary = recursive(n, binary);
        // counting the bit "1"
        return  (int)binary.stream()
                .filter(b -> b.equals("1"))
                .count();
    }

    private static List<String> recursive(int n, List<String> binary) {
        int result = n / 2;
        binary.add(0, String.valueOf(n % 2));
        if (result == 0) {
            return binary;
        } else {
            return recursive(result, binary);
        }
    }
}
