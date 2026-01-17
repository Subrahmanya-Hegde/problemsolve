package com.hegde.practice.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubSets(nums, ans, 0, new ArrayList<>());
        return ans;
    }

    public void generateSubSets(int[] nums, List<List<Integer>> ans, int start, List<Integer> currentSubSet){
        ans.add(new ArrayList<>(currentSubSet));
        for(int i = start; i < nums.length; i++){
            currentSubSet.add(nums[i]);
            generateSubSets(nums, ans, i + 1, currentSubSet);
            currentSubSet.removeLast();
        }
    }

    public void generateSubSetsRecursive(int[] nums, List<List<Integer>> ans, int index, List<Integer> currentSubSet) {
        if(index == nums.length){
            ans.add(new ArrayList<>(currentSubSet));
            return;
        }
        currentSubSet.add(nums[index]);
        generateSubSetsRecursive(nums, ans, index + 1, currentSubSet);
        currentSubSet.removeLast();
        generateSubSetsRecursive(nums, ans, index + 1, currentSubSet);
    }
}
