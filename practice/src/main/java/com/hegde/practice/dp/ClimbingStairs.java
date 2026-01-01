package com.hegde.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    public static int climbStairs(int stair) {
        List<Integer> steps = new ArrayList<>(Arrays.asList(1, 2));
        for(int i = 2; i < stair; i++){
            steps.add(steps.get(i - 1) + steps.get(i - 2));
        }
        return steps.get(stair - 1);
    }
}
