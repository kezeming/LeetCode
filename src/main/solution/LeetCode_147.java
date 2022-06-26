package main.solution;

import main.resources.ListNode;

public class LeetCode_147 {
	public ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode lastSorted = head, curr = head.next;
		while(curr != null) {
			if(lastSorted.val <= curr.val) {
				lastSorted = lastSorted.next;
			} else {
				ListNode prev = dummyHead;
				while(prev.next.val <= curr.val) {
					prev = prev.next;
				}
				lastSorted.next = curr.next;
				curr.next = prev.next;
				prev.next = curr;
			}
			curr = lastSorted.next;
		}
		return dummyHead.next;
	}
}