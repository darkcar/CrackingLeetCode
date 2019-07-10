package leetcode.twopointers;

public class LinkedListCycleTwoPointers141 {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			this.val = x;
		}
	}

	public boolean hasCycle(ListNode node) {
		if (node == null || node.next == null) { return false;}
		ListNode slow = node;
		ListNode fast = node.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
