package com.alerouge.demo.thread.countdownlatch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static final int ELEMENTS_NUMBER = 1000;

    @Test
    void name() throws InterruptedException {
        System.out.println("start");
        List<String> sharedList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(ELEMENTS_NUMBER);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        IntStream.rangeClosed(1, ELEMENTS_NUMBER)
                .forEach(c -> executorService.submit(new Thread(new Worker(sharedList, countDownLatch))));

        countDownLatch.await();

        sharedList.add("end");

        List<String> expectedList = new ArrayList<>();
        IntStream.rangeClosed(1, ELEMENTS_NUMBER)
                .forEach(e -> expectedList.add("added element"));
        expectedList.add("end");

        assertEquals(expectedList, sharedList);
        System.out.println("end");
    }
}