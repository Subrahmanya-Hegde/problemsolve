package com.hegde.practice.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


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
}

