package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

public class LengthOfLoop {

    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return lengthOfLoop(slow);
        }
        return 0;
    }

    private int lengthOfLoop(ListNode node){
        ListNode current = node;
        int length = 1;
        while (current.next != node){
            current = current.next;
            length++;
        }
        return length;
    }
}
