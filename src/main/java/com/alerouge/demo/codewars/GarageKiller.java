package com.alerouge.demo.codewars;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class GarageKiller {

    public static String run(String events) {
        int status = 0;
        int movement = 0;
        boolean pause = false;
        char[] eventsArray = events.toCharArray();
        int[] result = new int[eventsArray.length];
        for (int i = 0; i < eventsArray.length; i++) {
            char c = eventsArray[i];
            if (c == 'P') {
                if (status != 0 && status != 5) {
                    pause = !pause;
                } else {
                    // starting open/close
                    movement = status == 0 ? 1 : -1;
                }
            } else if (c == 'O') {
                movement *= -1;
            }
            if (!pause) {
                if ((movement > 0 && status >= 5) || (movement < 0 && status <= 0)) {
                    // finished to open/close
                    movement = 0;
                }
                status += movement;
            }
            result[i] = status;
        }
        return Arrays.stream(result).mapToObj(String::valueOf).collect(joining(""));
    }

}
