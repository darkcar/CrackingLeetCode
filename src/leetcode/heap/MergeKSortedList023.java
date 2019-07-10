package leetcode.heap;

import java.util.PriorityQueue;

import org.junit.Test;

public class MergeKSortedList023 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			this.val = x;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {return null;} 
		ListNode res = new ListNode(0), temp = res;;
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> (a.val - b.val));
		for (ListNode list : lists) {
			if (list != null) {
				heap.add(list);
			}
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			temp.next = cur;
			temp = temp.next;
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return res.next;
	}
	
	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode[] lists = {l1, l2, l3};
		ListNode res = mergeKLists(lists);
		print(res);
		
	}
	
	private void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
}
