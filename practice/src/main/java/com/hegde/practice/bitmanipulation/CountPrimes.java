package com.hegde.practice.bitmanipulation;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * Algo - https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        if(n <= 2)
            return 0;

        boolean[] isComposite = new boolean[n];
        int primeNumbers = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                primeNumbers++;

                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        return primeNumbers;
    }
}
