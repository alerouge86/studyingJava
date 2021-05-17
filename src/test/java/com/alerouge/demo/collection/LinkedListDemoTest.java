package com.alerouge.demo.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListDemoTest {

    @Test
    void usingLinkedListAsAdeque() {
        LinkedList<String> myList = new LinkedList<>(Arrays.asList("one", "two", "three"));
        myList.forEach(System.out::println);
        String firstElement = myList.pop();
        assertEquals(firstElement, "one");
        assertEquals(myList.size(), 2);
        myList.forEach(System.out::println);
    }

    @Test()
    void poppingElementInEmptyList_ThrowsException() {
        LinkedList<String> myList = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> {
            String firstElement = myList.pop();
            System.out.println(firstElement);
        });
    }

    @Test()
    void poolingElementInEmptyList_NotThrowsException() {
        LinkedList<String> myList = new LinkedList<>();
        String firstElement = myList.poll();
        System.out.println(firstElement);
    }
}