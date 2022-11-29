package com.alerouge.demo.codewars;

public class NextBiggerNumber {
    public static long nextBiggerNumber(long n) {
        String numberStr = String.valueOf(n);
        int index = numberStr.length() - 1;
        String result = checkSwitch(numberStr, index);
        return Long.parseLong(result);
    }

    private static String checkSwitch(String numberStr, int index) {
        if (numberStr.charAt(index) > numberStr.charAt(index-1)) {
            StringBuilder result = new StringBuilder(numberStr);
            result.setCharAt(index, numberStr.charAt(index - 1));
            result.setCharAt(index - 1, numberStr.charAt(index));
            return result.toString();
        } else {
            return checkSwitch(numberStr, --index);
        }
    }
}
