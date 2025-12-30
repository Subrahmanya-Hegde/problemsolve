package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

//TODO: Complete this.
public class LongestPathWithSameValue {

    public static int longestPathWithSameValue(TreeNode root){
        int[] maxLength = new int[]{0, 0};
        calculateLongestPathWithSameValue(root, maxLength);
        return maxLength[0];
    }

    private static void calculateLongestPathWithSameValue(TreeNode root, int[] maxLength){
        if(root == null)
            return ;
    }
}
