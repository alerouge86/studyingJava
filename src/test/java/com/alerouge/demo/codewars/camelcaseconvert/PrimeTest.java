package com.alerouge.demo.codewars.camelcaseconvert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "The.stealth,Warrior";
        System.out.println("input: "+input);
        assertEquals("TheStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
}