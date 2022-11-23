package com.alerouge.demo.thread.quiz.one;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> System.out.println("t1 is running"));
        Thread t2 = new Thread(() -> System.out.println("t2 is running"));

        t1.start();
        t1.sleep(1000);

        t2.start();
        t2.sleep(1000);

        System.out.println("Main..");


    }
}
