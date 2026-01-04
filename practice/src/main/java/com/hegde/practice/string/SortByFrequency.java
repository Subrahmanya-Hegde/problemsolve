package com.hegde.practice.string;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Map.Entry<Character, Integer>> charEntries = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry<Character, Integer>::getValue).reversed()
        );
        for (char c: s.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        charEntries.addAll(frequencyMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!charEntries.isEmpty()){
            Map.Entry<Character, Integer> charEntry = charEntries.poll();
            sb.append(charEntry.getKey().toString().repeat(charEntry.getValue()));
        }
        return sb.toString();
    }
}
