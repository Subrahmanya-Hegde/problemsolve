package com.hegde.practice.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Get the smallest sub-array/s whose sum is greater than the target.
 */
public class MinSubArrayToGetTarget {

    public static List<List<Integer>> getSmallestSubArraysToGetTarget(int[] array, int target) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int smallestSubArraySize = Integer.MAX_VALUE;
        List<Integer> currentSubArray = new ArrayList<>();
        List<List<Integer>> subArrays = new ArrayList<>();

        while (right < array.length) {
            currentSubArray.add(array[right]);
            sum += array[right++];
            while (sum >= target) {
                int curSubArraySize = right - left;
                if (curSubArraySize < smallestSubArraySize) {
                    subArrays.clear();
                    smallestSubArraySize = curSubArraySize;
                    subArrays.add(new ArrayList<>(currentSubArray));
                } else if (curSubArraySize == smallestSubArraySize) {
                    subArrays.add(new ArrayList<>(currentSubArray));
                }
                sum -= array[left];
                currentSubArray.remove(0);
                left++;
            }
        }
        return subArrays;
    }
}
