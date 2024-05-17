package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">
 * 102. Binary Tree Level Order Traversal</a>
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            int nodesInCurLvl = queue.size();
            List<Integer> lvlNodes = new ArrayList<>();
            while(nodesInCurLvl-- > 0){
                TreeNode curNode = queue.removeFirst();
                lvlNodes.add(curNode.val);
                if(curNode.left != null)
                    queue.add(curNode.left);
                if(curNode.right != null)
                    queue.add(curNode.right);
            }
            ans.add(new ArrayList<>(lvlNodes));
            lvlNodes.clear();
        }
        return ans;
    }
}
