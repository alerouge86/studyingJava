package com.alerouge.demo.thread.join;

public class SampleThread implements Runnable {

    private int n;

    public SampleThread(int n) {
        this.n = n;
        System.out.println(String.format("The thread %s has been created", Thread.currentThread().getName()));
    }

    @Override
    public void run() {
        System.out.println(String.format("The thread %s has been started", Thread.currentThread().getName()));
        while (n > 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n--;
        }
        System.out.println(String.format("The thread %s has been finished", Thread.currentThread().getName()));
    }
}
