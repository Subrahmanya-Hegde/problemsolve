package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

public class DeleteMidNode {

    /**
     * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
