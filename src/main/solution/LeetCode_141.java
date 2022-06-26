package main.solution;

import main.resources.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 判断链表有没有环，使用快慢指针
 */
public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}