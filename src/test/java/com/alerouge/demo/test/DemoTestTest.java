package com.alerouge.demo.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTestTest {

    @Test
    void createWhere() {

        String expected = "";

        DemoTest demoTest = new DemoTest();

        String query = demoTest.createWhere(true, true, true);
        assertEquals("", query.trim());

        query = demoTest.createWhere(false, false, false);
        assertEquals("", query.trim());

        query = demoTest.createWhere(true, false, false);
        assertEquals("AND A382MA=''AND A382CD=''", query.trim());

        query = demoTest.createWhere(true, true, false);
        assertEquals("AND A382CD=''", query.trim());

        query = demoTest.createWhere(true, false, true);
        assertEquals("AND A382MA=''", query.trim());

        query = demoTest.createWhere(false, true, false);
        assertEquals("AND A382MA<>''", query.trim());

        query = demoTest.createWhere(false, false, true);
        assertEquals("AND A382CD<>''", query.trim());

        query = demoTest.createWhere(false, true, true);
        assertEquals("", query.trim());


//        query = demoTest.createWhere(true, true, true);
//        assertEquals("", query.trim());
//
//        query = demoTest.createWhere(true, true, true);
//        assertEquals("", query.trim());
//
//        query = demoTest.createWhere(true, true, true);
//        assertEquals("", query.trim());
//
//        query = demoTest.createWhere(true, true, true);
//        assertEquals("", query.trim());
//
//        query = demoTest.createWhere(true, true, true);
//        assertEquals("", query.trim());

    }
}