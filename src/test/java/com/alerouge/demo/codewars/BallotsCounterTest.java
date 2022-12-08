package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

class BallotsCounterTest {
    @Test
    public void testGetWinner_01() {
        assertEquals("A", BallotsCounter.getWinner(Arrays.asList("A")));
    }

    @Test
    public void testGetWinner_02() {
        assertEquals("A", BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B", "A")));
    }

    @Test
    public void testGetWinner_03() {
        assertEquals(null, BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "B", "B")));
    }

    @Test
    public void testGetWinner_04() {
        assertEquals(null, BallotsCounter.getWinner(Arrays.asList("A", "A", "A", "B", "C", "B")));
    }

    @Test
    public void testGetWinner_05() {
        assertEquals(null, BallotsCounter.getWinner(Arrays.asList("A", "A", "B", "B", "C")));
    }

}