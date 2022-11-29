package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerBuilderTest {
    @Test
    public void basicTests() {
        assertEquals(String.join(",", "*"), String.join(",", TowerBuilder.towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"), String.join(",", TowerBuilder.towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", TowerBuilder.towerBuilder(3)));
    }

}