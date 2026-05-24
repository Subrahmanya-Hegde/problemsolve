package com.hegde.practice.tree.bfs;

import com.hegde.practice.helper.TreeNode;

/**
 * https://neetcode.io/problems/merge-two-binary-trees/question
 */
public class MergeTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return bfs(root1, root2);
    }

    private TreeNode bfs(TreeNode root1, TreeNode root2){
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }
}
