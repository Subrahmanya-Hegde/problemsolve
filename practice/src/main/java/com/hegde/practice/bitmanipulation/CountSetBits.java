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
}
