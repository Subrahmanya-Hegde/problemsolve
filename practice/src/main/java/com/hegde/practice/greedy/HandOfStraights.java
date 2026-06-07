package com.hegde.practice.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://neetcode.io/problems/hand-of-straights/question
 */
public class HandOfStraights {

    /**
     * hand=[1,2,4,2,3,5,3,4]
     * groupSize=4
     */
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: hand){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for(Integer key: frequencyMap.keySet().stream().sorted().toList()){
            int currentKeyFrequency = frequencyMap.get(key);
            if(currentKeyFrequency == 0)
                continue;

            for(int i = 1; i < groupSize; i++){
                int nextKey = key + i;
                if(!frequencyMap.containsKey(nextKey) || frequencyMap.get(nextKey) < currentKeyFrequency)
                    return false;
                frequencyMap.put(nextKey, frequencyMap.get(nextKey) - currentKeyFrequency);
            }
        }
        return true;
    }
}
