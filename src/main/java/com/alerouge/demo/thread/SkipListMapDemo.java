package com.alerouge.demo.thread;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SkipListMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<10; i++)
            map.put(i, i);
        System.out.println("map = " + map);

        Map.Entry<Integer, Integer> first = map.pollFirstEntry();
        System.out.println("first = " + first);

        System.out.println("map = " + map);
    }
}
