package com.alerouge.demo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting n threads..");
        int numberOfWorkers = 4;
        List<Integer> globalList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(numberOfWorkers);

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Thread> workers = Stream.generate(() -> new Thread(new Worker(globalList, countDownLatch, 15)))
                .limit(numberOfWorkers)
                .collect(Collectors.toList());

        workers.forEach(Thread::start);


        countDownLatch.await();

//        globalList.forEach(System.out::println);
        System.out.println("size globalList: " + globalList.size());

        service.shutdown();
        System.out.println("Main thread finished..");
    }
}

class Worker implements Runnable {
    private List<Integer> list;
    private CountDownLatch countDownLatch;
    final private int numbersToElaborate;

    public Worker(List<Integer> list, CountDownLatch countDownLatch, int societaToElaborate) {
        this.list = list;
        this.countDownLatch = countDownLatch;
        this.numbersToElaborate = societaToElaborate;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i< numbersToElaborate; i++) {
            // get some random number and add them to the list
            int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
            list.add(randomNumber);
            try {
                Thread.sleep(randomNumber*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The thread " + threadName + "has added " + numbersToElaborate + " numbers");
        countDownLatch.countDown();
    }
}