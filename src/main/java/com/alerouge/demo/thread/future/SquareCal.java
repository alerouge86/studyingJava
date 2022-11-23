package com.alerouge.demo.thread.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCal {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);
//    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(int i) {
        return executorService.submit(() -> {
            Thread.sleep(1000L);
            return i * i;
        });
    }
}
