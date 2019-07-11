package leetcode.list;

import org.junit.jupiter.api.Test;

public class SwapPairs024 {
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			this.val = x;
		}
	}
	public ListNode swapPairs(ListNode head) {
		// check if head is null or just one node
		if (head == null || head.next == null) return head;
		int tmpV = head.val;
		head.val = head.next.val;
		head.next.val = tmpV;
		if (head.next.next == null) return head;
		swapPairs(head.next.next);
		return head;
	}
	
	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		swapPairs(l1);
	}
}
