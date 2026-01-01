package com.hegde.practice.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> path,  List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0)
            return;
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, result);
            path.removeLast();
        }
    }
}
