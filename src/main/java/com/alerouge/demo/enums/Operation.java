package com.alerouge.demo.enums;

import java.util.function.BiFunction;

public enum Operation {
    ADD((x, y) -> x + y),
    MULTIPLY((x, y) -> x * y);

    private BiFunction<Integer, Integer, Integer> function;

    Operation(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    public Integer execute(Integer a, Integer b) {
        return this.function.apply(a, b);
    }

}
