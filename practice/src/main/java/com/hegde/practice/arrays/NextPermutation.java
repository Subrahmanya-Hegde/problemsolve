package com.hegde.practice.arrays;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * Start from the right, find the nums[i] < nums[i + 1].
 * Because this is where we should get the next permutation.
 * Then swap with the next bigger number and reverse the right side.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            swap(a, l++, r--);
        }
    }
}
