package com.hegde.practice.bitmanipulation;

/**
 * @see <a href="https://leetcode.com/problems/single-number/">
 * 136. Single Number</a>
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class UniqueNumber {

    public static int getUniqueNumber(int[] array){
        int ans = 0;
        for(int num : array){
            ans = ans ^ num;
        }
        return ans;
    }
}
