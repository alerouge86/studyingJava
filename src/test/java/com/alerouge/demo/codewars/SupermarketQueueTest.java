package com.alerouge.demo.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate the total time required for all the customers to
 * check out!
 * <p>
 * input
 * customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
 * n: a positive integer, the number of checkout tills.
 * output
 * The function should return an integer, the total time required.
 * <p>
 * Important
 * Please look at the examples and clarifications below, to ensure you understand the task correctly :)
 * <p>
 * Examples
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times
 * <p>
 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the
 * // queue finish before the 1st person has finished.
 * <p>
 * queueTime([2,3,10], 2)
 * // should return 12
 * Clarifications
 * There is only ONE queue serving many tills, and
 * The order of the queue NEVER changes, and
 * The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
 * N.B. You should assume that all the test input will be valid, as specified above.
 * <p>
 * P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool, with relation to running
 * multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool
 */
class SupermarketQueueTest {
    @Test
    public void myTest() {
        assertEquals(10, SupermarketQueue.solveSuperMarketQueue(new int[]{10, 2, 3, 3}, 2));
        assertEquals(12, SupermarketQueue.solveSuperMarketQueue(new int[]{2, 3, 10}, 2));
        assertEquals(12, SupermarketQueue.solveSuperMarketQueue(new int[]{5, 3, 4}, 1));
    }

    @Test
    public void testNormalCondition() {
        assertEquals(9, SupermarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, SupermarketQueue.solveSuperMarketQueue(new int[]{}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, SupermarketQueue.solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1));
    }

}