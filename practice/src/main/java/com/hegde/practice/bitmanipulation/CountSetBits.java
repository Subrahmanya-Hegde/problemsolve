package com.hegde.practice.bitmanipulation;

/**
 * https://takeuforward.org/plus/dsa/problems/count-the-number-of-set-bits
 */
public class CountSetBits {

    public static int countSetBits(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * Subtracting 1 flips the rightmost set bit to 0
     * and turns all bits to its right into 1s.
     *
     * ANDing with the original number clears that
     * rightmost set bit while leaving higher bits unchanged.
     *
     * Thus, each operation removes exactly one set bit.
     *
     * Since the loop runs once per set bit,
     * the time complexity is O(number of set bits),
     * making it an optimal approach.
     *
     * Example - n = 1101100, n - 1 will be 1101011, anding will set all the rightmost bits to zero.
     */
    public static int countSetBitsOptimal(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
