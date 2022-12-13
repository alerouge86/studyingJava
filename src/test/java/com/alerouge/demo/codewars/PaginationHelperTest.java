package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PaginationHelperTest {

    @Test
    void testSomething() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(2, helper.pageCount(), "pageCount");
        assertEquals(6, helper.itemCount(), "itemCount");
        assertEquals(4, helper.pageItemCount(0), "pageItemCount of 0");
        assertEquals(2, helper.pageItemCount(1), "pageItemCount of 1");
        assertEquals(-1, helper.pageItemCount(2), "pageItemCount of 2");
    }
    @Test
    void test2() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assertEquals(1, helper.pageIndex(5), "pageIndex of 5");
        assertEquals(0, helper.pageIndex(2), "pageIndex of 2");
        assertEquals(-1, helper.pageIndex(20), "pageIndex of 20");
        assertEquals(-1, helper.pageIndex(-10), "pageIndex of -10");
        assertEquals(-1, helper.pageIndex(0), "pageIndex of 0");
    }

    @Test
    void emptyCollection() {
        PaginationHelper<Character> helper = new PaginationHelper(Collections.emptyList(), 4);
        assertEquals(-1, helper.pageIndex(0), "pageIndex of 0");
    }
}