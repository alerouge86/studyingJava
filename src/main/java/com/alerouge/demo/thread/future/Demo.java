package com.alerouge.demo.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start");

        SquareCal squareCal = new SquareCal();

        Future<Integer> future1 = squareCal.calculate(10);
        Future<Integer> future2 = squareCal.calculate(100);

        while (!future1.isDone() || !future2.isDone()) {
            System.out.println(String.format("future1 is %s and future2 is %s", future1.isDone(), future2.isDone()));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("the result of future1 is %d and future2 is %d", future1.get(), future2.get()));
        System.exit(0);
    }
}
