package com.hegde.practice.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestNumber {

    public static int getKthLargestNumber(int[] array, int k){
        Queue<Integer> topKHighestElements = new PriorityQueue<>();
        for(int num : array){
            if(topKHighestElements.size() < k || topKHighestElements.peek() < num){
                topKHighestElements.offer(num);
            }
            if(topKHighestElements.size() > k){
                topKHighestElements.poll();
            }
        }
        return topKHighestElements.poll();
    }

}
