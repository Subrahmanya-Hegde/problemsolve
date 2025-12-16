package com.hegde.practice.arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutiveSequence(int[] array){
        int currentSequenceCount = 1, maxLongestSequence = 1;
        Arrays.sort(array);
        for(int i = 1; i < array.length; i++){
            if(array[i] - array[i - 1] == 1){
                currentSequenceCount++;
            }else {
                maxLongestSequence = Math.max(currentSequenceCount, maxLongestSequence);
                currentSequenceCount = 1;
            }
        }
        return Math.max(currentSequenceCount, maxLongestSequence);
    }
}
