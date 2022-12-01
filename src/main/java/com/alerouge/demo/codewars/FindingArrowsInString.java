package com.alerouge.demo.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, your task is to count the number and length of arrow symbols in that string and return an int using the following rules:
 * <p>
 * The string will only contain the characters ., -, =, <, >.
 * An arrow must start with either < or >.
 * Arrows are scored based on their length and direction, for example:
 * (Left-facing arrows are scored as negative, while Right-facing arrows are positive)
 * > is scored as 1
 * -> is scored as 2
 * < is scored as -1
 * <- is scored as -2
 * An arrow's tail (if it has one) must be entirely made up of either - or =. You cannot mix.
 * So, --> would be a valid arrow of length 3, but =-> would only count -> as a part of the arrow.
 * Additionally, arrows with a tail of = are scored twice as high as arrows with a tail of -, for example:
 * --> is scored as 3
 * ==> is scored as 6
 * <= is scored as -4
 * Double-sided arrows, like <-> or <===> are counted as 0.
 * . is an empty character and cannot be the tail of an arrow.
 * Examples
 * arrow_search('>.') # 1
 * arrow_search('<--..') # -3
 * arrow_search('><=><--') # -2
 * arrow_search('>===>->') # 11
 */
public class FindingArrowsInString {

    private static final String SPECIAL_CHAR = "@";

    public static int searchArrows(String string) {
        // removing all <=> and <-->
        string = string.replaceAll("<-+>", ".");
        string = string.replaceAll("<=+>", ".");

        return scoreString(string, ">") -                                           // score right facing
                scoreString(new StringBuilder(string).reverse().toString(), "<");   // score left facing
    }

    private static int scoreString(String str, String mainChar) {
        String char2 = mainChar.equals(">") ? "<" : ">";
        int lastIndexValid = str.lastIndexOf(mainChar);
        if (lastIndexValid == -1) return 0;

        // string must end with mainChar and not start with mainChar
        str = str.substring(0, lastIndexValid + 1);
        str = str.startsWith(mainChar) ? ".".concat(str) : str;
        // replace all char2 with "."
        str = str.replace(char2, ".");
        // special char (for when end with two or more main char)
        if (str.endsWith(mainChar + mainChar)) {
            str += SPECIAL_CHAR;
        }
        return Arrays.stream(str.split(mainChar))
                .mapToInt(FindingArrowsInString::scoreSegment)
                .sum();
    }

    private static int scoreSegment(String segment) {
        if (segment.equals(SPECIAL_CHAR)) return 0;

        Map<Boolean, Integer> arrowsMap = new HashMap<>();
        for (char c : segment.toCharArray()) {
            if (c == '.') {
                arrowsMap.clear();
            } else {
                boolean isDouble = c == '=';
                arrowsMap.merge(isDouble, 1, Integer::sum);
                arrowsMap.remove(!isDouble);
            }
        }
        int result = 0;
        if (arrowsMap.containsKey(Boolean.TRUE)) {
            result = (1 + arrowsMap.get(Boolean.TRUE)) * 2;
        } else {
            result = 1 + arrowsMap.getOrDefault(Boolean.FALSE, 0);
        }
        return result;
    }


}
