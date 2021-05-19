package com.alerouge.demo.thread.atlplus;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AtlPlusGetBlurredCardsTest {
    @Test
    void givingListTokens_thenReturnMapTokenBlurredCard_usingConcurrent() throws InterruptedException {
        List<String> tokens = new LinkedList<>(CardsHandler.MAP_MOCK.keySet());
        int numberOfThreads = 8;
        CardsHandler cardsHandler = new CardsHandler(tokens, numberOfThreads);
        Map<String, String> cards = cardsHandler.getCards();
        assertEquals(CardsHandler.MAP_MOCK, cards);
    }
}