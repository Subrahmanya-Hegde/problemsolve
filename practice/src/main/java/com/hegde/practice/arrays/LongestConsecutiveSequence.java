package com.hegde.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutiveSequence(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int num : array){
            set.add(num);
        }

        int longestConsecutiveLength = 0;
        for(int num: set){
            if(set.contains(num - 1)){
                continue;
            }
            int currentConsecutiveLength = 1;
            while(set.contains(num + currentConsecutiveLength)){
                currentConsecutiveLength++;
            }
            longestConsecutiveLength = Math.max(longestConsecutiveLength, currentConsecutiveLength);
        }
        return longestConsecutiveLength;
    }
}
