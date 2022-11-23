package com.alerouge.demo.stream.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ArrayList<Article> articles = Stream.generate(Article::new)
//                .limit(10)
                .limit(100_000)
//                .limit(10_000_000)
                .collect(Collectors.toCollection(ArrayList::new));

//        Spliterator<Article> articleSpliterator1 = articles.spliterator();
//        Spliterator<Article> articleSpliterator2 = articleSpliterator1.trySplit();

        long start = System.currentTimeMillis();


        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        ForkJoinTask<Integer> task = forkJoinPool.submit(() ->
                        articles
//                        .stream()
                                .parallelStream()
                                .mapToInt(Article::getCopiesSold)
                                .reduce(0, Integer::sum)
        );

        Integer value = task.get(5, TimeUnit.SECONDS);

        forkJoinPool.shutdown();

        System.out.println("value = " + value);


//        int sum = articles
////                .stream()
//                .parallelStream()
//                .mapToInt(Article::getCopiesSold)
//                .reduce(0, Integer::sum);
//        System.out.println("sum = " + sum);

        long timeElapsed = System.currentTimeMillis() - start;
        System.out.println("timeElapsed = " + timeElapsed);

    }

}
