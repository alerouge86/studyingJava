package com.alerouge.demo.lambdas.strategypattern;

import java.math.BigDecimal;

public class InnerClasses {
    public static final double EASTER_DISCOUNT = 0.5;
    public static final double CHRISTMAS_DISCOUNT = 0.1;

    public static void main(String[] args) {
        Discounter discounter = null;
        BigDecimal discount = null;
        // Easter discount (50%)
        discounter = new Discounter() {
            @Override
            public BigDecimal applyDiscount(BigDecimal amount) {
                return amount.multiply(BigDecimal.valueOf(OldStyle.EASTER_DISCOUNT));
            }
        };
        discount = discounter.applyDiscount(BigDecimal.valueOf(100));
        System.out.println("Easter discount (inner classes) = " + discount);
        // Christmas discount (10%)
        discounter = new Discounter() {
            @Override
            public BigDecimal applyDiscount(BigDecimal amount) {
                return amount.multiply(BigDecimal.valueOf(OldStyle.CHRISTMAS_DISCOUNT));
            }
        };
        discount = discounter.applyDiscount(BigDecimal.valueOf(100));
        System.out.println("Christmas discount (inner classes) = " + discount);
    }

}