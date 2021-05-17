package com.alerouge.demo.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<>();
        for (int i=0; i<10; i++)
            myLinkedList.push(String.valueOf(i));
        myLinkedList.forEach(System.out::println);
    }


}
