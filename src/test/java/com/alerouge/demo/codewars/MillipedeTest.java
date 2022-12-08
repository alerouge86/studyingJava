package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MillipedeTest {


    @Test
    void test() {
        String[] message = new String[]{"ale", "eso", "ori"};
        assertEquals(true, Millipede.check(message), String.join(", ", message));
    }

    @Test
    void testA() {
        String[] message = new String[]{"ale", "eso", "ura"};
        assertEquals(false, Millipede.check(message), String.join(", ", message));
    }

    @Test
    void test1() {
        String[] message = new String[]{"ale", "eso", "ori", "iru"};
        assertEquals(true, Millipede.check(message), String.join(", ", message));
    }

    @Test
    void test2() {
        String[] message = new String[]{"ale", "eso", "ori", "iru", "urc"};
        assertEquals(true, Millipede.check(message), String.join(", ", message));
    }


    @Test
    void oneLetterTest() {
        String[] message = new String[]{"east", "e", "e", "t", "t", "e", "time"};
        assertEquals(true, Millipede.check(message), String.join(", ", message));
    }

    @Test
    void randomTest() {
        String[] message = new String[]{"traffic", "tablet", "excess", "traffic", "trade"};
        assertEquals(false, Millipede.check(message), String.join(", ", message));
    }
    @Test
    void descriptionTrue() {
        String[] message = new String[]{"excavate", "endure", "desire", "screen", "theater", "excess", "night"};
        assertEquals(true, Millipede.check(message), String.join(", ", message));
    }
    @Test
    void descriptionFalse() {
        String[] message = new String[]{"trade", "pole", "view", "grave", "ladder", "mushroom", "president"};
        assertEquals(false, Millipede.check(message), String.join(", ", message));
    }
}