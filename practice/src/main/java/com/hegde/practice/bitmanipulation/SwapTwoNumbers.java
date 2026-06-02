package com.hegde.practice.bitmanipulation;

public class SwapTwoNumbers {

    /**
     * We know.
     * a ^ a = 0
     * So we can write - a = a ^ b ^ b
     * Based on this, we can swap it like this.
     */
    public void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
