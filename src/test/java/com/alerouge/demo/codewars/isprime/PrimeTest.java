package com.alerouge.demo.codewars.isprime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    public void testBasic() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertTrue (Prime.isPrime(2));
        assertTrue ( Prime.isPrime(73));
        assertFalse(Prime.isPrime(75));
        assertFalse(Prime.isPrime(-1));
    }

    @Test
    public void testPrime() {
        assertTrue(Prime.isPrime(3));
        assertTrue( Prime.isPrime(5));
        assertTrue( Prime.isPrime(7));
        assertTrue( Prime.isPrime(41));
        assertTrue( Prime.isPrime(5099));
    }

    @Test
    public void testNotPrime() {
        assertFalse( Prime.isPrime(4));
        assertFalse( Prime.isPrime(6));
        assertFalse( Prime.isPrime(8));
        assertFalse( Prime.isPrime(9));
        assertFalse( Prime.isPrime(45));
        assertFalse( Prime.isPrime(-5));
        assertFalse( Prime.isPrime(-8));
        assertFalse(Prime.isPrime(-41));
    }

    @Test
    public void testRandom() {
        assertFalse( Prime.isPrime(-2147483647));


        //        assertTrue( Prime.isPrime(2147483646));
//        assertTrue( Prime.isPrime(Integer.MAX_VALUE));
//        assertFalse( Prime.isPrime(Integer.MAX_VALUE / 2));
    }
}