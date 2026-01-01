package com.hegde.practice.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] input = new int[] {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(input)));
    }

}
