package com.hegde.practice.tree;

import com.hegde.practice.helper.TreeNodeV2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://neetcode.io/problems/populating-next-right-pointers-in-each-node/question
 */
public class NextPointersOfTree {

    public TreeNodeV2 connect(TreeNodeV2 root) {
        if (root == null) return null;

        Queue<TreeNodeV2> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++){
                TreeNodeV2 current = queue.poll();
                if(i < nodes - 1) current.next = queue.peek();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
        }
        return root;
    }
}
