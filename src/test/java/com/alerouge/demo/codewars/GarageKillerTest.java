package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageKillerTest {
    @Test
    public void testNormalOperation() {

        test("should start opening on buttonpress", ".P......", "01234555");
        test("should start opening on buttonpress", ".P......P......", "012345554321000");
        test("should start opening on buttonpress", ".P..P...", "01233333");
        test("should start opening on buttonpress", ".P..O...", "01232100");


        test("should start opening on buttonpress", ".P..", "0123");
        test("should start opening on buttonpress", "P..", "123");
        test("should stay closed unless button is pressed (no buttonpresses)", "..........", "0000000000");
        test("should open completely and stay open", "P....", "12345");
    }

    @Test
    public void testPause() {
        test("should start opening and pause on second buttonpress", "P.P..", "12222");
    }

    @Test
    public void testObstacles() {
        test("should reverse while opening", "P.O....", "1210000");
    }

    @Test
    public void testExample() {
        test("should start opening and reverse when obstacle", "..P...O.....", "001234321000");
    }

    private void test(String description,String events,String result) {
        assertEquals(result,Kata.run(events),description);
    }
}