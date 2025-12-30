package com.hegde.practice.heap;

import java.util.*;

public class KLargestNumberInEachSubArray {

    public static List<Integer> getKLargestNumberInEachSubArray(List<Integer> input, int k){
        int iteration = 1;
        Queue<Integer> kLargestNumbers = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(Integer number: input){
            if(!seen.contains(number)){
                kLargestNumbers.offer(number);
                seen.add(number);
            }
            if(kLargestNumbers.size() > k){
                kLargestNumbers.poll();
            }
            if(iteration >= k)
                answer.add(kLargestNumbers.peek());
            iteration++;
        }
        return answer;
    }
}
