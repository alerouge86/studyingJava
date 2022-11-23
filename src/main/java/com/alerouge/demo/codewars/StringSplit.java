package com.alerouge.demo.codewars;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {
    public static String[] solution(String s) {
        // for cases when the last pair is odd
        if (s.length() % 2 != 0) {
            s += "_";
        }
        // grouping by every 2 chars
        final String regex = ".{2}";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(s);

        return matcher.results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
}
