package com.alerouge.demo.thread.forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class SquareSumFactorial extends RecursiveTask<Integer> {

    private Integer n;

    public SquareSumFactorial(Integer number) {
        this.n = number;
    }

    @Override
    protected Integer compute() {
        System.out.println("n = " + n);
        if (n <= 1) {
            return n;
        }
        SquareSumFactorial squareSumFactorial = new SquareSumFactorial(n - 1);
        squareSumFactorial.fork();
        return n * n + squareSumFactorial.join();
    }

}
