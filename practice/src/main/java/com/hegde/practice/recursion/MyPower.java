package com.hegde.practice.recursion;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class MyPower {
    public double myPow(double x, int n) {
        if(n < 0){
            x = 1 / x;
            n *= -1;
        }
        return power(x, n);
    }

    /**
     * Example - (x ^ 11) can be written as (x ^ 5 * x ^ 5) * x.
     * So halve keep on halving the n till you reach 0.
     * If n is odd return half * half * x
     * If n is even return half * half.
     */
    public double power(double x, int n){
        if(n == 0)
            return 1;
        double half = power(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
