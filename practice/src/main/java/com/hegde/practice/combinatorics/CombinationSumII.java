package com.hegde.practice.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(
            int[] candidates,
            int start,
            int remaining,
            List<Integer> path,
            List<List<Integer>> result){

        if(remaining == 0){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > remaining)
                break;

            path.add(candidates[i]);
            dfs(candidates, i + 1, remaining - candidates[i], path, result);
            path.removeLast();
        }
    }
}
