package com.alerouge.demo.collection.experiment;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SpeedTestUsages {
    public static void main(String[] args) {
        Instant start = Instant.now();

        final int counter = 1_000_000;

        List<Integer> list = new ArrayList<>();
//        List<Integer> list = new LinkedList<>();

        System.out.println("n.processors = " + Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < counter; i++) {
            list.add(i);
        }

        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("duration = " + duration + " | size: " + list.size());
    }
}
