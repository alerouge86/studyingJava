package com.alerouge.demo.codewars;


import java.util.*;
import java.util.stream.Collectors;

public class SupermarketQueue {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        Deque<Integer> customersDeque = Arrays.stream(customers).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> listTills = new ArrayList<>(Collections.nCopies(n, null));
        List<Integer> listPreviousSum = new ArrayList<>(Collections.nCopies(n, 0));
        boolean finished = false;
        int indexTime = 0;
        while (!finished) {
            for (int tillIndex = 0; tillIndex < listTills.size(); tillIndex++) {
                Integer tillNow = listTills.get(tillIndex);
                if (tillNow == null || indexTime >= listTills.get(tillIndex) + listPreviousSum.get(tillIndex)) {
                    Integer nextClient = customersDeque.poll();
                    listTills.set(tillIndex, nextClient);
                    if (nextClient == null && listTills.stream().noneMatch(Objects::nonNull)) {
                        finished = true;
                    }
                    listPreviousSum.set(tillIndex, tillNow == null ? 0 : listPreviousSum.get(tillIndex) + tillNow);
                }
            }
            indexTime++;
        }
        return indexTime - 1;
    }
}
