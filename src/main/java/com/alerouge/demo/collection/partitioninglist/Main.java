package com.alerouge.demo.collection.partitioninglist;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Integer, List<Integer>> groups = intList.stream()
                .collect(Collectors.groupingBy(s -> (s - 1) / 3));

        System.out.println("groups; = " + groups);
        System.out.println("groups.values(); = " + groups.values());

        List<List<Integer>> subsets = new ArrayList<>(groups.values());
        System.out.println("subsets = " + subsets);

    }
}
