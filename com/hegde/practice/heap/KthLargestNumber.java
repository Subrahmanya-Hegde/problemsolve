package com.hegde.practice.heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">
 * 215. Kth Largest Element in an Array</a>
 * Given an integer array nums and an integer k, return the kth largest element in the array <strong>without sorting.</strong>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestNumber {

    public static int getKthLargestNumber(int[] array, int k){
        Queue<Integer> topKHighestElements = new PriorityQueue<>();
        for(int num : array){
            if(topKHighestElements.size() < k || (!topKHighestElements.isEmpty() && topKHighestElements.peek() < num)){
                topKHighestElements.offer(num);
            }
            if(topKHighestElements.size() > k){
                topKHighestElements.poll();
            }
        }
        return !topKHighestElements.isEmpty() ? topKHighestElements.poll() : -1;
    }

}
