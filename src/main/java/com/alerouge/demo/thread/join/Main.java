package com.alerouge.demo.thread.join;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread has started");

        Thread myThread = new Thread(new SampleThread(3));

        myThread.start();

        myThread.join();


        System.out.println("Main thread has finished");

    }
}
