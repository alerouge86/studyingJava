package com.alerouge.demo.thread.synch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        SumCalculation summation = new SumCalculation();
        IntStream.range(0, 1_000)
                .forEach(count -> service.submit(summation::calculate));

        service.awaitTermination(2000, TimeUnit.MILLISECONDS);
        System.out.println("result = " + summation.getSum());

    }
}
