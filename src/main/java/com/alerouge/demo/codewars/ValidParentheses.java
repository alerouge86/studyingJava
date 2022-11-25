package com.alerouge.demo.codewars;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static boolean validParentheses(String parents) {
        Deque<Character> deque = new ArrayDeque<>();
        try {
            for (char c : parents.toCharArray()) {
                if (c == '(') {
                    deque.push(c);
                } else if (c == ')') {
                    deque.pop();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return deque.isEmpty();
    }
}
