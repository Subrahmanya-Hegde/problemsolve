package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">
 * 124. Binary Tree Maximum Path Sum</a>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class PathWithMaxSum {

    public static int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[]{Integer.MIN_VALUE};
        traverse(root, maxPathSum);
        return maxPathSum[0];
    }

    public static int traverse(TreeNode root, int[] maxPathSum){
        if(root == null)
            return 0;
        int leftSum = traverse(root.left, maxPathSum);
        int rightSum = traverse(root.right, maxPathSum);

        int curMaxPathSum = Math.max(root.val, root.val + leftSum);
        curMaxPathSum = Math.max(curMaxPathSum, root.val + rightSum);
        maxPathSum[0] = Math.max(maxPathSum[0], curMaxPathSum);
        maxPathSum[0] = Math.max(maxPathSum[0], root.val + leftSum + rightSum);
        return curMaxPathSum;
    }

}
