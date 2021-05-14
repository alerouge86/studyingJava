package com.alerouge.demo.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedDemoTest {

    @Test
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Calculator calculator = new Calculator();
        int loops = 1_000_000;

        IntStream.range(0, loops)
                .forEach(count -> service.submit(calculator::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(loops, calculator.getSum());
    }

}