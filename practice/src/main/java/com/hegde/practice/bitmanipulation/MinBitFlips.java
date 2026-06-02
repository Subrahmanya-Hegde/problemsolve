package com.hegde.practice.bitmanipulation;

/**
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 */
public class MinBitFlips {

    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        return getSetBitsCount(xor);
    }

    private int getSetBitsCount(int number){
        int setBitsCount = 0;
        while(number > 0){
            number &= (number - 1);
            setBitsCount ++;
        }
        return setBitsCount;
    }
}
