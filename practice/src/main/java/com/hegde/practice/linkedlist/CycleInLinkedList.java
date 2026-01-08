package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> visited = new HashSet<>();
        while(current != null){
            if(visited.contains(current)){
                return current;
            }
            visited.add(current);
            current = current.next;
        }
        return null;
    }
}
