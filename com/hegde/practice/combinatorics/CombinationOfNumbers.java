package com.hegde.practice.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfNumbers {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> result){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        int remaining = k - path.size();
        for(int i = start; i <= n - remaining + 1; i++){
            path.add(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}
