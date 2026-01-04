package com.hegde.practice.string;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaxNestingDepthOfParenthesis {

    public int maxDepth(String s) {
        int maxDepth = 0, currentDepth = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            if(c == ')'){
                currentDepth--;
            }
        }
        return maxDepth;
    }
}
