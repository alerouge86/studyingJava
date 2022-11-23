package com.alerouge.demo.enums;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Operation operation = Operation.ADD;
//        System.out.println("operation = " + operation);
//        System.out.println("operation val = " + operation.getVal());

//        Operation[] values = Operation.values();
//        Arrays.stream(values).forEach(System.out::println);

        int a = 2;
        int b = 5;

        int resultSum = Operation.ADD.execute(a, b);
        System.out.println("resultSum = " + resultSum);

        int resultMultiply = Operation.MULTIPLY.execute(a, b);
        System.out.println("resultMultiply = " + resultMultiply);

    }
}
