package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">
 * 235. Lowest Common Ancestor of a Binary Search Tree</a>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < q.val ? getLowestAncestor(root, q, p) : getLowestAncestor(root, p, q);
    }

    /**
     * Since it's BST we can take advantage of nodes values.
     * We need to find the root node where root node <= rightNode and root >= leftNode.
     * Otherwise, we can move the root node to the side where the nodes can be.
     * That is root > rightNode then traverse on the left side of the root.
     * @param root
     * @param greaterNode
     * @param lesserNode
     * @return lowestCommonAncestor
     */
    private static TreeNode getLowestAncestor(TreeNode root, TreeNode greaterNode, TreeNode lesserNode){
        if(greaterNode.val >= root.val && lesserNode.val <= root.val)
            return root;
        return getLowestAncestor(root.val < greaterNode.val ? root.right : root.left, greaterNode, lesserNode);
    }
}
