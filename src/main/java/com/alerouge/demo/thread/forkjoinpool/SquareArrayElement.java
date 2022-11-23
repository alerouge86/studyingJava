package com.alerouge.demo.thread.forkjoinpool;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SquareArrayElement extends RecursiveTask<Integer> {
    private Integer[] myArray;
    private static final int THRESHOLD = 4;

    public SquareArrayElement(Integer[] myArray) {
        this.myArray = myArray;
    }

    @Override
    protected Integer compute() {
        if (this.myArray.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubTaskes())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing(this.myArray);
        }
    }

    private List<SquareArrayElement> createSubTaskes() {
        List<SquareArrayElement> subTaskes = new ArrayList<>();
        subTaskes.add(new SquareArrayElement(Arrays.copyOfRange(this.myArray, 0, this.myArray.length / 2)));
        subTaskes.add(new SquareArrayElement(Arrays.copyOfRange(this.myArray, this.myArray.length / 2, this.myArray.length)));
        return subTaskes;
    }

    private Integer processing(Integer[] array) {
        return Arrays.stream(array)
                .filter(n -> n > 10 && n < 27)
                .mapToInt(n -> n * n)
                .sum();
    }

    public Integer calculation() {
        return Arrays.stream(this.myArray)
//                .parallel()
                .filter(n -> n > 10 && n < 27)
                .mapToInt(n -> n * n)
                .sum();
    }

}
