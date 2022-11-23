package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitCountingTest {

    @Test
    public void testGame() {
        assertEquals(1, BitCounting.countBits(4));
        assertEquals(2, BitCounting.countBits(5));
        assertEquals(3, BitCounting.countBits(7));
        assertEquals(2, BitCounting.countBits(9));
        assertEquals(2, BitCounting.countBits(10));
        assertEquals(5, BitCounting.countBits(1234));
    }
}