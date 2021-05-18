package com.alerouge.demo.collection;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);
        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        map.get(4);
        System.out.println(keys);

        map.get(1);
        System.out.println(keys);

        map.get(3);
        System.out.println(keys);
    }

}
