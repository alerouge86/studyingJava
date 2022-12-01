package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class FindingArrowsInStringTest {
    @Test
    void testExample() {
        assertEquals(1, FindingArrowsInString.searchArrows(">."));
        assertEquals(-3, FindingArrowsInString.searchArrows("<--.."));
        assertEquals(-2, FindingArrowsInString.searchArrows("><=><--"));
        assertEquals(11, FindingArrowsInString.searchArrows(">===>->"));
        assertEquals(0, FindingArrowsInString.searchArrows("......"));
        assertEquals(0, FindingArrowsInString.searchArrows("<-->"));
        assertEquals(3, FindingArrowsInString.searchArrows("-->"));
    }

    @Test
    void testSimple() {
        assertEquals(0, FindingArrowsInString.searchArrows(""));
        assertEquals(2, FindingArrowsInString.searchArrows(">>"));
        assertEquals(1, FindingArrowsInString.searchArrows(">><"));
        assertEquals(-2, FindingArrowsInString.searchArrows(">><="));
        assertEquals(-1, FindingArrowsInString.searchArrows(">-><="));
        assertEquals(-2, FindingArrowsInString.searchArrows("<=>-><="));
    }

    @Test
    void testAdvanced() {
        assertEquals(-3, FindingArrowsInString.searchArrows(">>><.=<=<..=<>"));
        assertEquals(2, FindingArrowsInString.searchArrows(">><<=>><>><"));
        assertEquals(-4, FindingArrowsInString.searchArrows(">>><><<=="));
        assertEquals(-2, FindingArrowsInString.searchArrows(">...-><<=<==>><"));
        assertEquals(-3, FindingArrowsInString.searchArrows("<>><=>-<=><="));
        assertEquals(6, FindingArrowsInString.searchArrows(">-><..=>><"));
        assertEquals(-7, FindingArrowsInString.searchArrows("<>><=<=>-<=><="));
        assertEquals(-10, FindingArrowsInString.searchArrows(">-<=<=><=<=.>><"));
        assertEquals(-10, FindingArrowsInString.searchArrows("<>..<=<<==><=>-><<=="));
        assertEquals(-72, FindingArrowsInString.searchArrows("<==================================="));
        assertEquals(-26, FindingArrowsInString.searchArrows(">.<<------------------------..<"));
        assertEquals(0, FindingArrowsInString.searchArrows("............."));
    }

    @Test
    void testRandom() {
        for (int i = 0; i < 20; i++) {
            String randomString = buildRandomString(100);
            assertEquals(searchArrows(randomString), FindingArrowsInString.searchArrows(randomString));
        }
        for (int i = 0; i < 20; i++) {
            String randomString = buildRandomString(10000);
            assertEquals(searchArrows(randomString), FindingArrowsInString.searchArrows(randomString));
        }
        for (int i = 0; i < 10; i++) {
            String randomString = buildRandomString(1000000);
            assertEquals(searchArrows(randomString), FindingArrowsInString.searchArrows(randomString));
        }
    }

    private String buildRandomString(int length) {
        Random random = new Random();
        String characters = ".<>-=";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(5)));
        }
        return sb.toString();
    }

    private int searchArrows(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '>') {
                if (i > 0 && (string.charAt(i - 1) == '=' || string.charAt(i - 1) == '-')) {
                    int j = i - 1;
                    while (j >= 0 && string.charAt(j) == string.charAt(i - 1)) {
                        j--;
                    }
                    sum += (i - j) * (string.charAt(i - 1) == '=' ? 2 : 1);
                } else {
                    sum++;
                }
            }
            if (string.charAt(i) == '<') {
                if (i < string.length() - 1 && (string.charAt(i + 1) == '=' || string.charAt(i + 1) == '-')) {
                    int j = i + 1;
                    while (j < string.length() && string.charAt(j) == string.charAt(i + 1)) {
                        j++;
                    }
                    sum -= (j - i) * (string.charAt(i + 1) == '=' ? 2 : 1);
                } else {
                    sum--;
                }
            }
        }
        return sum;
    }
}