package com.hegde.practice.arrays;

public class MaxSumArray {

    //Kadane's algorithm
    public static int maximumSubArray(int[] array){
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : array) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

}
