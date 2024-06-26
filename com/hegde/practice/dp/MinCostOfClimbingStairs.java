package com.hegde.practice.dp;

public class MinCostOfClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length < 2)
            return 0;

        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }
}
