package com.alerouge.demo.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncrementString {
    public static String incrementString(String str) {
        String regex = "\\d*$";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);

        long numericPart;
        String numericPartStr = "1";
        if (matcher.find()) {
            numericPartStr = !matcher.group(0).isEmpty()  ? matcher.group(0) : "0";
            str = compile.matcher(str).replaceAll("");
        }
        if (!numericPartStr.isEmpty()) {
            String additionalNumericPart = "";
            try {
                numericPart = Long.parseLong(numericPartStr) + 1;
            } catch (NumberFormatException e) {
                numericPart = Long.parseLong(numericPartStr.substring(numericPartStr.length() - 18)) + 1;
                additionalNumericPart = numericPartStr.substring(0, numericPartStr.length() - 18);
                if (String.valueOf(numericPart).length() < 18) {
                    additionalNumericPart += "0".repeat(18 - String.valueOf(numericPart).length());
                }
            }
            int leadingZeroCount = numericPartStr.length() - String.valueOf(numericPart).length();
            if (leadingZeroCount > 0 && additionalNumericPart.isEmpty()) {
                numericPartStr = "0".repeat(leadingZeroCount) + additionalNumericPart + numericPart;
            } else {
                numericPartStr = additionalNumericPart +String.valueOf(numericPart);
            }
        }
        return str + numericPartStr;
    }
}
