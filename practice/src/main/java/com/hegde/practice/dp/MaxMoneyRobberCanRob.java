package com.hegde.practice.dp;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/description/">
 * 198. House Robber</a>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class MaxMoneyRobberCanRob {

    //System.out.println(MaxMoneyRobberCanRob.rob(new int[] {1,2,3,1}));
    public static int rob(int[] array) {
        if(array.length == 0)
            return 0;
        int prev1 = 0, prev2 = 0;
        for(int num : array){
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }

}
