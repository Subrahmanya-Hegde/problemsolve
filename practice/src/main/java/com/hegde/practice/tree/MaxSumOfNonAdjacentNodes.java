package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

public class MaxSumOfNonAdjacentNodes {

    public int maxSumOfNonAdjacentNodes(TreeNode node){
        int[] result = dfs(node);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node){
        if(node == null)
            return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int picked = node.val + left[1] + right[1];
        int skipped = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{picked, skipped};
    }
}
