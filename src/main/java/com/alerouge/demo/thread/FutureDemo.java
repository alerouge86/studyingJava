package com.alerouge.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareCalculation squareCalculation = new SquareCalculation();
        Future<Integer> future1 = squareCalculation.calculate(10);
        Future<Integer> future2 = squareCalculation.calculate(100);
        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(String.format(
                    "future1 is %s and future2 is %s",
                    future1.isDone() ? "done" : "not done",
                    future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println(result1 + " and " + result2);
        squareCalculation.shutDown();
    }
}

class SquareCalculation {
//    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private ExecutorService executor = Executors.newFixedThreadPool(2);


    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("calculating for: " + input);
            Thread.sleep(1000);
            return input * input;
        });
    }

    public void shutDown() {
        this.executor.shutdown();
    }
}
