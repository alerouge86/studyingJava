package com.alerouge.demo.exercise;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {

    public static void main(String[] args) {

        String[] chars = {"c", "b", "a"};
        String str = "abbccabaccba";

        Test1 test1 = new Test1();
        String result = test1.findSmallestSubstring(chars, str);
        System.out.println("result = " + result);

    }

    public String findSmallestSubstring(String[] chars, String str) {
        final Set<String> setChars = Arrays.stream(chars).collect(Collectors.toSet());
        int charsLength = setChars.size();

        if (str.length() < charsLength) return "";

        for (int charIndex = 0; charIndex < str.length() - charsLength; charIndex++) {
            String stringTest = str.substring(charIndex, charIndex + charsLength);
            Set<String> setTest = stringTest.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.toSet());
            if (setTest.equals(setChars)) {
                return stringTest;
            }
        }
        return "";
    }

}
