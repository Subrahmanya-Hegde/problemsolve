package com.hegde.practice.greedy;

/**
 * https://neetcode.io/problems/jump-game/question
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        if(length < 1) return true;

        int goal = length - 1;
        for(int i = length - 2; i >= 0; i--){
            if(nums[i] + i >= goal)
                goal = i;
        }
        return goal == 0;
    }
}