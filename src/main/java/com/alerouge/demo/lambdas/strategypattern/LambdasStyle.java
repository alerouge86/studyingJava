package com.alerouge.demo.lambdas.strategypattern;

import java.math.BigDecimal;

public class LambdasStyle {
    public static void main(String[] args) {
        BigDecimal discount = null;
        // Easter discount (50%)
//        Discounter easterDiscounter = amount -> amount.multiply(BigDecimal.valueOf(OldStyle.EASTER_DISCOUNT));
//        discount = easterDiscounter.applyDiscount(BigDecimal.valueOf(100));
//        System.out.println("Easter discount (lambdas) = " + discount);

        // Christmas discount (10%)
//        Discounter christmasDiscounter = amount -> amount.multiply(BigDecimal.valueOf(OldStyle.CHRISTMAS_DISCOUNT));
//        discount = christmasDiscounter.applyDiscount(BigDecimal.valueOf(100));
//        System.out.println("Christmas discount (lambdas) = " + discount);

        Discounter easterDiscounter = Discounter.easterDiscounter();
        discount = easterDiscounter.applyDiscount(BigDecimal.valueOf(100));
        System.out.println("Easter discount (lambdas) = " + discount);

        Discounter christmasDiscounter = Discounter.christmasDiscounter();
        discount = christmasDiscounter.applyDiscount(BigDecimal.valueOf(100));
        System.out.println("Christmas discount (lambdas) = " + discount);

    }
}

@FunctionalInterface
interface Discounter {
    BigDecimal applyDiscount(BigDecimal amount);
    static Discounter easterDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(OldStyle.EASTER_DISCOUNT));
    }
    static Discounter christmasDiscounter() {
        return amount -> amount.multiply(BigDecimal.valueOf(OldStyle.CHRISTMAS_DISCOUNT));
    }
}