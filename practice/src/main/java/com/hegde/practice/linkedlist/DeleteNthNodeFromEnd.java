package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class DeleteNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1, head);
        ListNode slow = newHead, fast = newHead;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
