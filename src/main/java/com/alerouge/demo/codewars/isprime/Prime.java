package com.alerouge.demo.codewars.isprime;

import java.util.Optional;
import java.util.stream.IntStream;

public class Prime {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == Integer.MAX_VALUE) return true;

        boolean prime = true;
        int index = 2;
        while (prime && index <= num / 2) {
            prime = num % index++ != 0;
        }
        return prime;
    }

    public static boolean isPrime2(int num) {
        // method too slow with big numbers
        if (num <= 1) return false;

        Optional<Integer> any = IntStream.range(2, num)
                .filter(n -> num % n == 0)
                .boxed()
                .findAny();
        return any.isEmpty();
    }
}
