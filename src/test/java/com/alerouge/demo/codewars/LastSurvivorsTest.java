package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LastSurvivorsTest {
    @Test
    @Order(1)
    void ordinary() {
        assertEquals("ac", sort(LastSurvivors.lastSurvivors("abaa")), String.format("given: %s", "abaa"));
        assertEquals("c", sort(LastSurvivors.lastSurvivors("zzab")), String.format("given: %s", "zzab"));
        assertEquals("", sort(LastSurvivors.lastSurvivors("")), String.format("given: %s", ""));
    }

    @Test
    @Order(2)
    void zeroLength() {
        assertEquals("", sort(LastSurvivors.lastSurvivors("")), String.format("given: %s", ""));
    }

    @Test
    @Order(3)
    void newEdge() {
        String str ="xsdlafqpcmjytoikojsecamgdkehrqqgfknlhoudqygkbxftivfbpxhxtqgpkvsrfflpgrlhkbfnyftwkdebwfidmpauoteahyh";
        assertEquals("acdeghlmnqrvyz", sort(LastSurvivors.lastSurvivors(str)), String.format("given: %s", str));
    }

    @Test
    @Order(4)
    void randomTest() {
        String str ="xndnelamkoobevykhpbqxkukkofv";
        assertEquals("acdghklnpruwz", sort(LastSurvivors.lastSurvivors(str)), String.format("given: %s", str));
    }

    static private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}