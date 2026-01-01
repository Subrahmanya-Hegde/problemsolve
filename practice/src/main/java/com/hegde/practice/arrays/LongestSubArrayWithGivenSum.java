package com.hegde.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
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

    public static int longestSubArrayWithSumKWithNegative(int[] array, int target){
        int length = array.length, answer = 0, prefixSum = 0;
        Map<Integer,Integer> firstIndexOfSum = new HashMap<>();

        for(int i = 0; i < length; i++){
            prefixSum+= array[i];

            int reminder = prefixSum - target;

            if (firstIndexOfSum.containsKey(reminder)) {
                int startIndex = firstIndexOfSum.get(reminder);
                answer = Math.max(answer, i - startIndex);
            }
            firstIndexOfSum.putIfAbsent(prefixSum, i);
        }
        return answer;
    }
}
