package com.hegde.practice.recursion;

/**
 * https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k
 */
public class SubsequenceWithTargetSum {

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int[] ans = new int[]{0};
        backtrack(nums, k, 0, ans, 0);
        return ans[0];
    }

    private void backtrack(int[] nums, int k, int start, int[] ans, int curSum){
        if (curSum == k){
            ans[0]++;
            return;
        }
        for(int i = start; i < nums.length; i++){
            curSum += nums[i];
            backtrack(nums, k, i + 1, ans, curSum);
            curSum -= nums[i];
        }
    }
}
