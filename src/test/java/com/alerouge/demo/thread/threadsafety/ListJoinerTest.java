package com.alerouge.demo.thread.threadsafety;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ListJoinerTest {

    @Test
    @Disabled
    void givingTwoList_whenJoinWithNotSynchronized_thenUnsortedList() throws InterruptedException {
//        List<Integer> result = new ArrayList<>();
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());

        int indexStart = 1;
        int indexEnd = 101;

        List<Integer> list1 = IntStream.rangeClosed(indexStart, indexEnd/2).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.range((indexEnd/2)+1, indexEnd).boxed().collect(Collectors.toList());
        List<Integer> listResult = IntStream.range(indexStart, indexEnd).boxed().collect(Collectors.toList());

        Thread thread1 = new Thread(() -> result.addAll(list1));
        Thread thread2 = new Thread(() -> result.addAll(list2));

        thread1.start();
        thread2.start();

//        Thread.sleep(1000);

//        listResult.add(3);
        assertEquals(listResult, result);
    }

    @Test
    void name() throws InterruptedException {
//        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        List<Integer> syncCollection = Collections.synchronizedList(new ArrayList<>());
        Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
        thread1.start();
        thread2.start();

        Thread.sleep(1000);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), syncCollection);

//        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
//        assertTrue(result.equals(syncCollection));


    }
}