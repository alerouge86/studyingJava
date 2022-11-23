package com.alerouge.demo.thread.forkjoinpool;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SquareArrayElementTest {

    @Test
    void usingOnlyStream_givenArrayInteger_thenReturnSumOfSquaresOfNumberBetween10_27() {
        Instant start = Instant.now();
        Integer[] myArray = getBigArray();
        SquareArrayElement squareArrayElement = new SquareArrayElement(myArray);
        int result = squareArrayElement.calculation();
        Instant finish = Instant.now();
        long duration = Duration.between(start, finish).toMillis();
        System.out.println("duration stream = " + duration);

        /*
         * 15 24 20
         * 225 + 576 + 400 = 1201
         * */
        assertEquals(5816, result);
    }

    @Test
    @Disabled
    void usingForkJoinPool_givenArrayInteger_thenReturnSumOfSquaresOfNumberBetween10_27() {
//        Integer[] myArray = {15, 7, 24, 32, 20};
//        Integer[] myArray = {15, 7, 24, 32, 20, 48, 50, 125, 600, 80, 79, 82};

        Instant start = Instant.now();
        Integer[] myArray = getBigArray();

        SquareArrayElement squareArrayElement = new SquareArrayElement(myArray);

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        int result = forkJoinPool.invoke(squareArrayElement);
        Instant finish = Instant.now();
        long duration = Duration.between(start, finish).toMillis();
        System.out.println("duration fork join = " + duration);

        /*
         * 15 24 20
         * 225 + 576 + 400 = 1201
         * */
        assertEquals(5816, result);
    }

    private Integer[] getBigArray() {
        return IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .toArray(Integer[]::new);
    }

}