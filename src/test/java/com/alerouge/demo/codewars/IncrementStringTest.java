package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncrementStringTest {
    private static void doTest(String str, String expected) {
        assertEquals(expected, IncrementString.incrementString(str), "input: <"+str+">");
    }

    @Test
    public void exampleTests() {
        doTest("foobar000", "foobar001");
        doTest("foo", "foo1");
        doTest("foobar001", "foobar002");
        doTest("foobar99", "foobar100");
        doTest("foobar099", "foobar100");
        doTest("", "1");
    }

    @Test
    public void staticTests() {
//        doTest("fo99obar99", "fo99obar100");
//        doTest("a15567734733142", "a15567734733143");
//        doTest("a000039924904172832018694065913278865190", "a000039924904172832018694065913278865191");
        doTest("K\\q}HiVD0000682031933767952746733", "K\\q}HiVD0000682031933767952746734");
    }
}