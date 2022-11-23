package com.alerouge.demo.thread.waitnotify;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Thread senderThread = new Thread(new Sender(data));
        Thread receiverThread = new Thread(new Receiver(data));

        senderThread.start();
        receiverThread.start();



    }
}
