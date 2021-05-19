package com.alerouge.demo.thread.atlplus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class CardsHandler {
    private List<String> tokens;
    private int numberOfThreads;

    public CardsHandler(List<String> tokens, int numberOfThreads) {
        this.tokens = tokens;
        this.numberOfThreads = numberOfThreads;
    }

    public static final Map<String, String> MAP_MOCK = Map.of(
            "123", "321",
            "456", "654",
            "789", "987");

    public Map<String, String> getCards() throws InterruptedException {
        Map<String, String> mapResult = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch countDownLatch = new CountDownLatch(this.tokens.size());

        List<Future<Card>> futureCards = new LinkedList<>();

        for (String token : tokens) {
            futureCards.add(executorService.submit(new CardWorker(token, countDownLatch)));
        }
        // waiting for all terminate
        countDownLatch.await();
        futureCards.forEach(fc -> {
            try {
                mapResult.put(fc.get().getToken(), fc.get().getBlurred());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        return mapResult;
    }

    private class CardWorker implements Callable<Card> {
        private String token;
        private CountDownLatch countDownLatch;

        public CardWorker(String token, CountDownLatch countDownLatch) {
            this.token = token;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Card call() throws Exception {
            Card card = null;
            try {
                card = new Card(token, getBlurred(token));
            } finally {
                countDownLatch.countDown();
            }
            return card;
        }

        private String getBlurred(String token) {
            return MAP_MOCK.get(token);
        }
    }
}
