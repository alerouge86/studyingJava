package com.alerouge.demo.codewars;

import java.util.stream.IntStream;

/**
 * Build Tower
 * Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors. A tower block is represented with "*" character.
 */
public class TowerBuilder {
    public static String[] towerBuilder(int nFloors) {
        int lengthFloor = nFloors * 2 - 1;
        return IntStream.rangeClosed(1, nFloors)
                .mapToObj(i -> makeFloor(i, lengthFloor))
                .toArray(String[]::new);
    }

    private static String makeFloor(int floorNumber, int lengthFloor) {
        int asteriskCount = floorNumber * 2 - 1;
        return " ".repeat((lengthFloor - asteriskCount) / 2) +
                "*".repeat(asteriskCount) +
                " ".repeat((lengthFloor - asteriskCount) / 2);
    }
}

