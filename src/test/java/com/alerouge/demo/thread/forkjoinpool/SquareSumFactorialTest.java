package com.alerouge.demo.thread.forkjoinpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class SquareSumFactorialTest {

    @Test
    void squareSumFactorial() {
        int number = 4;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SquareSumFactorial squareSumFactorial = new SquareSumFactorial(number);
        Integer result = forkJoinPool.invoke(squareSumFactorial);
        assertEquals(result, 30);
    }
}