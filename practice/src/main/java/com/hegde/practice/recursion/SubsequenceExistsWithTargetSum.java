package com.hegde.practice.recursion;

/**
 * https://takeuforward.org/plus/dsa/problems/check-if-there-exists-a-subsequence-with-sum-k
 */
public class SubsequenceExistsWithTargetSum {

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return subsequenceExists(nums, 0, k, k);
    }

    private boolean subsequenceExists(int[] nums, int currentIndex, int sum, int target){
        if(sum == 0)
            return true;
        if(sum < 0 || currentIndex == nums.length)
            return false;
        return subsequenceExists(nums, currentIndex + 1, sum, target) ||
                subsequenceExists(nums, currentIndex + 1, sum - nums[currentIndex], target);
    }
}
