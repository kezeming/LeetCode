package main.solution;

import main.resources.ListNode;

public class LeetCode_234 {
	public boolean isPalindrome(ListNode head) {
		if(head == null) {
			return true;
		}

		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean res = true;
		while(res && p2 != null) {
			if(p1.val != p2.val) {
				res = false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		firstHalfEnd.next = reverseList(secondHalfStart);
		return res;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}