package com.hegde.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));
        if(start >= nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, result);
            subset.removeLast();
        }
    }
}