package com.hegde.practice.bitmanipulation;

/**
 * https://leetcode.com/problems/power-of-two
 */
public class IsPowerOfTwo {

    /**
     * why it works?
     * If a number is a power of two then it looks something like this -
     * 1, 10, 100, 1000.
     * n - 1 looks like, 0, 01, 0111. So if we apply and operation result should be zero if
     * the number is power of two.
     */
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ((n & (n-1)) == 0);
    }
}
