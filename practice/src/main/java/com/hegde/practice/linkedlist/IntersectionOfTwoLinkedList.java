package com.hegde.practice.linkedlist;

import com.hegde.practice.helper.ListNode;

public class IntersectionOfTwoLinkedList {


    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
     * Idea:
     * Traverse both linked lists using two pointers.
     * When one pointer reaches the end, redirect it to the head of the other list.
     * Why it works?
     * Consider two linked lists that intersect at node `c`.
     * A: a → b → c → d → e → f
     * B: a1 → c → d2
     * Lengths:
     * - List A length = a + c
     * - List B length = b + c
     * where `c` is the common intersection tail.
     * The problem is that the starting points are misaligned due to different lengths.
     * If we traverse both lists normally, the pointers will not reach `c` at the same time.
     * To fix this, we make each pointer traverse BOTH lists completely.
     * Pointer paths:
     * d1: a → b → c → d → e → f → a1 → c → d2
     * d2: a1 → c → d2 → a → b → c → d → e → f
     * Now both pointers traverse the same total distance:
     * (length of A + length of B)
     * Since both pointers cover equal distance, when they enter the common part `c`,
     * they are perfectly aligned and will meet at the intersection node.
     * If an intersection exists:
     * - Both pointers will meet exactly at the intersection node `c`.
     * If no intersection exists:
     * - Both pointers will reach `null` at the same time.
     * This guarantees:
     * - No extra space
     * - No explicit length calculation
     * - At most two passes over each list
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA , p2 = headB;
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}
