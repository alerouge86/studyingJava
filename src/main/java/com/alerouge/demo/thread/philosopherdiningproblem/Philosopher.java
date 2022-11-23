package com.alerouge.demo.thread.philosopherdiningproblem;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + " thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + " left fork picked up");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + " right fork picked up - eating");

                        doAction(System.nanoTime() + " put down right fork");
                    }
                    doAction(System.nanoTime() + " put down left fork - returning to thinking");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
