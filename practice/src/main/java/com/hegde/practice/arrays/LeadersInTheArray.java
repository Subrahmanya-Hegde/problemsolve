package com.hegde.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInTheArray {

    public static List<Integer> leadersInTheArray(int[] array){
        List<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = array.length - 2; i >= 0; i--){
            if(array[i] >= max){
                answer.add(array[i]);
                max = array[i];
            }
        }
        Collections.reverse(answer);
        return answer;
    }
}
