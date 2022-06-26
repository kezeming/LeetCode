package main.solution;

import main.resources.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//重排链表
//快慢指针 + 链表翻转 + 链表插入
public class LeetCode_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        ListNode pre = null;
        slow.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        curr = pre;
        slow = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
            curr = next;
            slow = slow.next.next;
        }
        return ;
    }
}