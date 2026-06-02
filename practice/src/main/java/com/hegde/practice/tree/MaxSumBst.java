package com.hegde.practice.tree;

import com.hegde.practice.helper.BstNodeInfo;
import com.hegde.practice.helper.TreeNode;

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 */
public class MaxSumBst {

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        generateBstNodeInfo(root);
        return maxSum;
    }

    private BstNodeInfo generateBstNodeInfo(TreeNode root) {
        if(root == null){
            return new BstNodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        BstNodeInfo leftBstNodeInfo = generateBstNodeInfo(root.left);
        BstNodeInfo rightBstNodeInfo = generateBstNodeInfo(root.right);

        if(isSubTreeABst(root.val, leftBstNodeInfo, rightBstNodeInfo)){
            int sum = leftBstNodeInfo.sum + rightBstNodeInfo.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            return new BstNodeInfo(Math.min(root.val, leftBstNodeInfo.minRight), Math.max(root.val, rightBstNodeInfo.maxLeft), sum, true);
        }
        return new BstNodeInfo(0, 0, 0, false);
    }

    private boolean isSubTreeABst(int currentNodeVal, BstNodeInfo leftBstNodeInfo, BstNodeInfo rightBstNodeInfo){
        return leftBstNodeInfo.isBst && rightBstNodeInfo.isBst && currentNodeVal > leftBstNodeInfo.maxLeft && currentNodeVal < rightBstNodeInfo.minRight;
    }
}
