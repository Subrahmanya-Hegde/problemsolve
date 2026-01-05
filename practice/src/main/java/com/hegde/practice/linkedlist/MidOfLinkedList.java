package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MidOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
