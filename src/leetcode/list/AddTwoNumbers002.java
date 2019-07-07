package leetcode.list;

import org.junit.jupiter.api.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list. 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @author xwang
 *
 */
public class AddTwoNumbers002 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int v) {
			val = v;
		}
	}
	
	/**
	 * Input: 2->4->3 + 5->6->4 = 7->0->8
	 * @param l1
	 * @param l2
	 * @return
	 */
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null || l2 == null) {return null;}
			ListNode p = new ListNode(0), res = p;
			int carry = 0;
			while (l1 != null || l2 != null) {
				int sum = carry;
				if (l1 != null) {
					sum += l1.val;
	                l1 = l1.next;
				}
				
				if (l2 != null) {
					sum += l2.val;
	                l2 = l2.next;
				}
				carry = sum / 10;
				ListNode t = new ListNode(sum % 10);
				p.next = t;
				p = p.next;
	            if (l1 == null && l2 == null && carry != 0) {
	                p.next = new ListNode(carry);
	            }
			}
			return res.next;
		}
	
	@Test
	public void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1, l2);
		System.out.println(res);
	}
}









