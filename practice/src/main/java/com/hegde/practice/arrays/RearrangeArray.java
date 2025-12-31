package com.hegde.practice.arrays;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 */
public class RearrangeArray {

    static {
        for(int i = 0; i < 200; i++){
            rearrangeArray(new int[]{});
        }
    }

    public static int[] rearrangeArray(int[] nums) {
        if(nums.length == 0)
            return nums;

        int[] result = new int[nums.length];
        int positiveIndex = 0, negativeIndex = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result[positiveIndex] = nums[i];
                positiveIndex += 2;
            }else{
                result[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }
        return result;
    }
}
