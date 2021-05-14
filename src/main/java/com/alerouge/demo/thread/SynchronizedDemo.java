package com.alerouge.demo.thread;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SynchronizedDemo {

    public static void main(String[] args)  {
        Instant start = Instant.now();
        /**
         * =========================================================================================================================================================
         * =========================================================================================================================================================
         * =========================================================================================================================================================
         */

        Calculator calculator = new Calculator();
        IntStream.range(0, 1_000_000_000)
                .forEach( count -> calculator.calculate());


        /**
         * =========================================================================================================================================================
         * =========================================================================================================================================================
         * =========================================================================================================================================================
         */
        Instant end = Instant.now();
        long durationMs = Duration.between(start, end).toMillis();
        System.out.println("final: " + calculator.getSum() + " duration (ms): " + durationMs);
//        System.out.println("final: duration (ms): " + durationMs);
    }

}

class Calculator {
    private int sum;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}