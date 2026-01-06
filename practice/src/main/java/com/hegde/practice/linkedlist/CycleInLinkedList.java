package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class CycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
