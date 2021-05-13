package com.alerouge.demo.thread;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        System.out.println("initial: " + demo.getValue());
        Instant start = Instant.now();
        // duration (ms): 1449
        long loops = 1_000_000_000L;







        Instant end = Instant.now();
        long durationMs = Duration.between(start, end).toMillis();
        System.out.println("final: " + demo.getValue() + " duration (ms): " + durationMs);
    }

}

