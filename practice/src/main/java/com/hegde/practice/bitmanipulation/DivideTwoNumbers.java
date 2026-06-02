package com.hegde.practice.bitmanipulation;

public class DivideTwoNumbers {

    /**
     * APPROACH:
     *
     * We implement division without using /, * or %.
     *
     * Key idea:
     * Division is repeated subtraction, but subtracting one divisor
     * at a time is O(N). We optimize using doubling (bit shifts).
     *
     * Strategy:
     * 1) Work with positive longs to avoid overflow.
     * 2) Repeatedly subtract the largest power-of-two multiple
     *    of divisor that fits into the remaining dividend.
     * 3) Accumulate how many times we subtracted (quotient).
     * 4) Apply the correct sign at the end.
     *
     * Example: 20 / 3
     * 20 - 12 (3×4) → remainder 8
     * 8  - 6  (3×2) → remainder 2
     * quotient = 4 + 2 = 6
     *
     * Time Complexity: O(log N)
     * (each step removes a large chunk)
     */
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE; //Integer overflow

        long remaining = Math.abs((long) dividend);
        long baseDivisor = Math.abs((long) divisor);

        long quotient = 0;

        while (canSubtract(remaining, baseDivisor)) {
            long[] remainingAndQuotient = findLargestChunk(remaining, baseDivisor);
            remaining -= remainingAndQuotient[0];
            quotient += remainingAndQuotient[1];
        }

        boolean sameSign = (dividend >= 0) == (divisor >= 0);
        long signedQuotient = sameSign ? quotient : -quotient;

        return (int) signedQuotient;
    }

    private boolean canSubtract(long remaining, long divisor) {
        return remaining >= divisor;
    }

    /**
     * Returns:
     * [0] = largest chunkValue = divisor * (power of two) that is <= remaining
     * [1] = chunkMultiple = that power of two
     */
    private long[] findLargestChunk(long remaining, long divisor) {
        long chunkValue = divisor;
        long chunkMultiple = 1;

        while (remaining >= doubleOf(chunkValue)) {
            chunkValue = doubleOf(chunkValue);
            chunkMultiple = doubleOf(chunkMultiple);
        }
        return new long[]{chunkValue, chunkMultiple};
    }

    private static long doubleOf(long value) {
        return value * 2;
    }
}
