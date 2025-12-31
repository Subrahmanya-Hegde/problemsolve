package com.hegde.practice.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> numberFrequency = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<Integer, Long>> topKFrequentNumber = numberFrequency.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<Integer, Long>::getValue).reversed())
                .limit(k)
                .toList();

        return topKFrequentNumber.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public int[] topKFrequentUsingHeap(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(var i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq
                = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        int[] result = new int[k];

        for(var i : map.entrySet()){
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }

        int i = 0;
        while(k > 0){
            result[i++] = pq.poll().getKey();
            k--;
        }
        return result;
    }
}

