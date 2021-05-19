package com.alerouge.demo.thread;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class EventWindowSortTest {
    @Test
    void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        EventWindowSort eventWindowSort = new EventWindowSort();
        int numberOfThreads = 2;
        Runnable producer = () -> IntStream
                .rangeClosed(0, 100)
                .forEach((index) -> eventWindowSort.acceptEvent(new Event(ZonedDateTime.now().minusSeconds(index), UUID.randomUUID().toString())));
        for (int i=0; i<numberOfThreads; i++) {
            executorService.execute(producer);
        }
        ConcurrentNavigableMap<ZonedDateTime, String> eventsFromLastMinute = eventWindowSort.getEventsFromLastMinute();
        System.out.println("eventsFromLastMinute = " + eventsFromLastMinute);
        long countEventsOlderThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isBefore(ZonedDateTime.now().minusMinutes(1)))
                .count();
        assertEquals(countEventsOlderThanOneMinute, 0);
    }
}