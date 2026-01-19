package com.hegde.practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> curr, List<List<Integer>> result){
        if(k == 0 && target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i <= 9; i++){
            curr.add(i);
            backtrack(i + 1, k - 1, target - i, curr, result);
            curr.removeLast();
        }
    }
}
