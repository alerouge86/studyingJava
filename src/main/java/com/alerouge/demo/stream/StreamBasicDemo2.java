package com.alerouge.demo.stream;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasicDemo2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> evenOddMap = list.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));

        System.out.println("evenOddMap = " + evenOddMap);
        System.out.println("Even numbers:  = " + evenOddMap.get(true) );
    }

}
