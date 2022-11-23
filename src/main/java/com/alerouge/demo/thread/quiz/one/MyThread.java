package com.alerouge.demo.thread.quiz.one;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("running " + Thread.currentThread().getName());
    }

}
