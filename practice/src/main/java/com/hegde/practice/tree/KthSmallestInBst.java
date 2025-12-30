package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">
 * 230. Kth Smallest Element in a BST</a>
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestInBst {

    public int kthSmallest(TreeNode root, int k) {
        int[] kthSmallestNum = new int[]{-1};
        int[] nodesTraversed = new int[]{0};
        nodesTraversed[0] = k;
        traverse(root, nodesTraversed, kthSmallestNum);
        return kthSmallestNum[0];
    }

    private void traverse(TreeNode root, int[] nodesTraversed, int[] kthSmallestNum){
        if(root == null){
            return;
        }
        traverse(root.left, nodesTraversed, kthSmallestNum);
        nodesTraversed[0]--;
        if(nodesTraversed[0] == 0){
            kthSmallestNum[0] = root.val;
            return;
        }
        traverse(root.right, nodesTraversed, kthSmallestNum);
    }
}
