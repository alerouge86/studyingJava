package com.alerouge.demo.thread.threadsafety;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        Thread thread1 = new Thread(() ->result.addAll(Arrays.asList(1, 2, 3, 4, 5)));
        Thread thread2 = new Thread(() ->result.addAll(Arrays.asList(6, 7, 8, 9, 10)));

        thread1.start();
        thread2.start();



    }
}
