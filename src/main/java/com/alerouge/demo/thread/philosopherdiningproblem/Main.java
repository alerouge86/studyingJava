package com.alerouge.demo.thread.philosopherdiningproblem;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int philosopherNumber = 5;
        Philosopher[] philosophers = new Philosopher[philosopherNumber];
        Object[] forks = new Object[philosopherNumber];
        for (int i = 0; i < philosopherNumber; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosopherNumber; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % philosopherNumber];

//            philosophers[i] = new Philosopher(leftFork, rightFork);

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }

}
