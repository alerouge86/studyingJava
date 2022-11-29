package com.alerouge.demo.codewars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
//    Kata kh = new Kata();

    @Test
    public void tests() {
        assertEquals("67", Kata.numberToString(67));
        assertEquals("123", Kata.numberToString(123));
        assertEquals("999", Kata.numberToString(999));
    }
}