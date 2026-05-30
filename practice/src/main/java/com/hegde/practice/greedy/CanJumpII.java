package com.hegde.practice.greedy;

/**
 * https://neetcode.io/problems/jump-game-ii/question
 */
public class CanJumpII {

    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0, furthestEnd = 0;

        for(int i = 0; i < nums.length - 1; i++){
            furthestEnd = Math.max(i + nums[i], furthestEnd);
            if(i == currentEnd){
                currentEnd = furthestEnd;
                jumps++;
            }
        }
        if (furthestEnd < nums.length - 1) return -1;
        return jumps;
    }
}
