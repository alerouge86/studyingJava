package com.alerouge.demo.collection.experiment;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class SpeedTestUsages {
    public static void main(String[] args) {
        final int counter = 10_000_000;
//        final int counter = 1_000;
//         ========================================================================================================================

        List<MyPojo> list = Stream.generate(() -> new MyPojo())
                .limit(counter)
                .collect(toList());

        ArrayList<MyPojo> arrayList = new ArrayList<>(list.size());
        list.forEach(e -> arrayList.add(e));
//        LinkedList<MyPojo> linkedList = new LinkedList<>();
//        list.forEach(e -> linkedList.add(e));

        Instant start = Instant.now();




//        List<MyPojo> listCreated = arrayList.stream()
//                .map((e) -> {
//                    e.setRandomString(UUID.randomUUID().toString().split("-")[0]);
//                    return e;
//                })
//                .collect(toList());

        // parallel stream
        List<MyPojo> listCreated = arrayList.parallelStream()
                .map((e) -> {
                    e.setRandomString(UUID.randomUUID().toString().split("-")[0]);
                    return e;
                })
                .collect(toList());


//        listCreated.forEach(System.out::println);


        // ========================================================================================================================
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("List - duration = " + duration + " | size: " + listCreated.size());
    }
}
