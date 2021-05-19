package com.alerouge.demo.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapOperationsDemo {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i=65; i<=90; i++)
            map.put(i, (char)i);

        map.forEach( (key, value) -> {
//            System.out.println("the key is: " + key + " and the value: " + value);
        });

//        Character getOrDefaultValue = map.getOrDefault(70, 'x');
//        System.out.println("getOrDefaultValue = " + getOrDefaultValue);

        System.out.println("before the value is = " + map.get(91));
        Character putIfAbsent = map.putIfAbsent(91, 'a');
        System.out.println("putIfAbsent = " + putIfAbsent);
        System.out.println("after the value is = " + map.get(91));

    }
}
