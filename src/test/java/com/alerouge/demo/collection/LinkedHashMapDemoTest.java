package com.alerouge.demo.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LinkedHashMapDemoTest {

    static LinkedHashMap<Integer, String> map;

    @BeforeAll
    static void beforeAll() {
        map = new LinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);
    }

    @Test
    void testingAccessOrder_insteadInsertionOrder() {
        Set<Integer> keys = map.keySet();
        assertEquals("[1, 2, 3, 4, 5]", keys.toString());
        map.get(3);
        assertEquals("[1, 2, 4, 5, 3]", keys.toString());
        map.get(1);
        assertEquals("[2, 4, 5, 3, 1]", keys.toString());
    }

}