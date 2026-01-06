package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteANode {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
    }
}
