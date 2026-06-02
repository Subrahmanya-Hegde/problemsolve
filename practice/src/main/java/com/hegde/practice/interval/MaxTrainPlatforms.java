package com.hegde.practice.interval;

import java.util.Arrays;

/**
 * https://takeuforward.org/plus/dsa/problems/minimum-number-of-platforms-required-for-a-railway
 */
public class MaxTrainPlatforms {
    public int findPlatform(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platforms = 0, maxPlatforms = 0;
        int i = 0, j = 0;
        int trains = arrival.length;

        //Increment on arrival, decrement on departure, track max overlap
        while(j < trains && i < trains){
            if(arrival[i] <= departure[j]){
                platforms++;
                i++;
                maxPlatforms = Math.max(platforms, maxPlatforms);
            }else{
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
}
