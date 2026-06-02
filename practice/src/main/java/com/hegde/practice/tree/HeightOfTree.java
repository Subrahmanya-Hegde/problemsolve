package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">
 * 104. Maximum Depth of Binary Tree</a>
 * Given the root of a binary tree, return its maximum depth.
 *
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class HeightOfTree {
    int height = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return height;
    }

    private void dfs(TreeNode root, int curDepth){
        if(root == null)
            return;
        curDepth++;
        dfs(root.left, curDepth);
        dfs(root.right, curDepth);
        this.height = Math.max(this.height, curDepth);
    }
}
