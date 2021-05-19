package com.alerouge.demo.thread;

import org.junit.jupiter.api.Test;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class SkipListMapDemoTest {
    @Test
    void givenSkipList_whenNavConcurrently_thenCountCorrect() throws InterruptedException {
        NavigableMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();
        int count = countMapElementByPollingFirstEntry(skipListMap, 10000, 4);
        assertEquals(10000 * 4, count);
    }
    @Test
    void givenTreeMap_whenNavConcurrently_thenCountError() throws InterruptedException {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        int count = countMapElementByPollingFirstEntry(treeMap, 10000, 4);
        System.out.println("count = " + count);
        assertNotEquals(10000 * 4, count);
    }

    private int countMapElementByPollingFirstEntry(NavigableMap<Integer, Integer> navigableMap, int elementCount, int concurrencyLevel) throws InterruptedException {
        for (int i=0; i<elementCount*concurrencyLevel; i++)
            navigableMap.put(i, i);
        ExecutorService service = Executors.newFixedThreadPool(concurrencyLevel);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < concurrencyLevel; i++) {
            service.execute(() -> {
                for (int j=0; j<elementCount; j++) {
                    if (navigableMap.pollFirstEntry()!=null) {
                        counter.incrementAndGet();
                    }
                }
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        return counter.get();
    }
}