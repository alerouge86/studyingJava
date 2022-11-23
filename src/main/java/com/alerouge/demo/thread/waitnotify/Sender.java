package com.alerouge.demo.thread.waitnotify;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

        List<String> messages = Arrays.asList("message 1", "message 2", "message 3", "message 4", "message 5", "message 6", "end");

        for (String message : messages) {
            data.send(message);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
