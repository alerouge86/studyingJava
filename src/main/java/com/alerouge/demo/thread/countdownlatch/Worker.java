package com.alerouge.demo.thread.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private List<String> list;
    private CountDownLatch countDownLatch;
    private static final int SLEEPING_TIME = 1000 * 10;

    public Worker(List<String> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.list.add("added element");
        this.countDownLatch.countDown();
    }
}
