package com.hegde.practice.arrays;

public class LongestSubArrayWithGivenSum {
    public static int longestSubArrayWithSumK(int[] array, int target){
        int length = array.length, answer = 0;
        int slowIndex = 0, sum = 0;
        for(int fastIndex = 0; fastIndex < length; fastIndex++){
            sum += array[fastIndex];

            while (slowIndex <= fastIndex && sum > target){
                sum -= array[slowIndex];
                slowIndex++;
            }

            if(sum == target){
                answer = Math.max(answer, (fastIndex - slowIndex + 1));
            }
        }
        return answer;
    }
}
