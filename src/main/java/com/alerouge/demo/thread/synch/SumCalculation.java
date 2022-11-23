package com.alerouge.demo.thread.synch;

public class SumCalculation {

    private int sum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}