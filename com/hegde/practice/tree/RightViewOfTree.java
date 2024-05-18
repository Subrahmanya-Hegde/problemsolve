package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/description/">
 * 199. Binary Tree Right Side View</a>
 * Given the root of a binary tree,
 * imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class RightViewOfTree {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewNodesValueList = new ArrayList<>();
        getRightView(root, rightViewNodesValueList, 0);
        return rightViewNodesValueList;
    }

    private static void getRightView(TreeNode root, List<Integer> rightViewNodesValueList, int depth){
        if(root == null)
            return;
        if(rightViewNodesValueList.size() == depth)
            rightViewNodesValueList.add(root.val);
        getRightView(root.right, rightViewNodesValueList, depth + 1);
        getRightView(root.left, rightViewNodesValueList, depth + 1);
    }
}
