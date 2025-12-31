package com.hegde.practice.arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int totalNumbers = nums.length;
        int[] ans = new int[totalNumbers];

        int[] leftProductArray = new int[totalNumbers];
        int[] rightProductArray = new int[totalNumbers];
        leftProductArray[0] = 1;
        rightProductArray[0] = 1;
        int leftProduct = 1, rightProduct = 1;
        for(int i = 0; i < totalNumbers; i++){
            leftProductArray[i] = leftProduct;
            rightProductArray[totalNumbers - i - 1] = rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[totalNumbers - i - 1];
        }

        for(int i = 0; i < totalNumbers; i++){
            ans[i] = leftProductArray[i] * rightProductArray[i];
        }
        return ans;
    }
}
