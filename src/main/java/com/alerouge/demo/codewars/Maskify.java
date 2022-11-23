package com.alerouge.demo.codewars;

public class Maskify {

    public static String maskify(String str) {
        final int countCharVisible = 4;
        final String charHidden = "#";
        if (str.length() < countCharVisible) return str;

        int strVisibleLength = str.length() - countCharVisible;
        return charHidden.repeat(strVisibleLength) + str.substring(strVisibleLength);
    }
}
