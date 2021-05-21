package com.alerouge.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsConvertDemo {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);
        System.out.println("list = " + list);
        try {
            list.add(6);
            System.out.println("list = " + list);
        } catch (Exception e) {
            System.out.println(e);
        }
        list = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println("list 2 = " + list);
    }
}
