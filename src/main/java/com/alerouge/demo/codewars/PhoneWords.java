package com.alerouge.demo.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a string of numbers, you must perform a method in which you will translate this string into text, following the next image.
 * for example if you get 22 you will b, if you get 222 you will return c. if you get 2222 return ca
 *
 * Here some samples:
 *
 * 443355555566604466690277733099966688 -> hello how are you., 55282 -> kata.
 *
 * 1 is used to separate letters with the same number.
 *
 * always transform the number to the letter with the maximum value, as long as it does not have a 1 in the middle.
 *
 * 777777 = "sq". 7717777 = "qs".
 *
 * you cannot type digits
 *
 * 0 are spaces in the string.
 *
 * Given a empty string, return empty string.
 *
 * Return a lowercase string.
 */
public class PhoneWords {
    public static String phoneWords(String str) {
        if (str == null || str.isEmpty()) return "";

        // if containing only spaces:
        if (str.chars().filter(c -> c != '0').count() == 0) return " ".repeat(str.length());

        // grouping by words
        String[] words = str.split("0");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(decodeWord(words[i]));
            if (i < words.length - 1 || str.endsWith("0")) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static String decodeWord(String word) {
        StringBuilder result = new StringBuilder();
        // grouping by digits
        String regex = "(\\d)\\1*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            String group = matcher.group(0);
            if (group.equals("1")) continue;
            // adding "1" if needed
            group = addOnes(group);
            // grouping by "1"
            String[] letters = group.split("1");
            for (String letter : letters) {
                result.append(decodeLetter(letter));
            }
        }
        return result.toString();
    }

    private static char decodeLetter(String group) {
        int length = group.length() - 1;
        int asciiCode = switch (group.charAt(0)) {
            case '2' -> 97 + length;
            case '3' -> 100 + length;
            case '4' -> 103 + length;
            case '5' -> 106 + length;
            case '6' -> 109 + length;
            case '7' -> 112 + length;
            case '8' -> 116 + length;
            case '9' -> 119 + length;
            default -> 0;
        };
        return (char) asciiCode;
    }

    private static String addOnes(String group) {
        int divisor = group.startsWith("7") ? 4 : 3;
        StringBuilder result = new StringBuilder();
        int counterOne = 0;
        for (int i = 0; i < group.length(); i++) {
            if (counterOne++ == divisor) {
                result.append("1");
                counterOne = 0;
            }
            result.append(group.charAt(i));
        }
        return result.toString();
    }

}
