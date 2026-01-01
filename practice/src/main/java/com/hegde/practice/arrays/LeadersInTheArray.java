package com.hegde.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class LeadersInTheArray {

    public static int[] leadersInTheArray(int[] array){
        int arrayLength = array.length;

        int max = array[arrayLength - 1];
        array[arrayLength - 1] = -1;
        for(int i = arrayLength - 2; i >= 0; i--){
            int current = array[i];
            array[i] = max;
            max = Math.max(max, current);
        }
        return array;
    }
}
