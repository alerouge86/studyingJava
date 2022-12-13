package com.alerouge.demo.codewars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Random;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;


class KataTest {
    @Test
    public void test1() {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        assertArrayEquals(r, Kata.inArray(a, b));
    }

    @Test
    public void myTest() {
        String a[] = new String[]{ "vita", "cri", "ale" };
        String b[] = new String[] { "joy", "alessandro", "tom", "vitale", "jack" };
        String r[] = new String[] { "ale", "vita" };
        assertArrayEquals(r, Kata.inArray(a, b));
    }
}