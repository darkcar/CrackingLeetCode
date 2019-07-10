package leetcode.twopointers;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleHashMap141 {
	class ListNode {
		int val; 
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}
	public boolean hasCycle(ListNode node) {
		Set<ListNode> set = new HashSet<ListNode>();
		while (node != null) {
			if (set.contains(node)) {
				return true;
			}
			set.add(node);
			node = node.next;
		}
		return false;
	}
}
