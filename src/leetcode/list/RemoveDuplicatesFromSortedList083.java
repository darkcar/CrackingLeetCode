package leetcode.list;

import org.junit.jupiter.api.Test;

import leetcode.list.RemoveDuplicatesFromSortedList083.ListNode;

public class RemoveDuplicatesFromSortedList083 {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int v) {
			val = v;
		}
	}

	/**
	 * 1->1->2->3->3
	 * 1->1
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while (p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			}
			p = p.next;
		}
		return head;
	}
	
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		deleteDuplicates(head);
	}
}
