package leetcode.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given two binary trees, write a function to check 
 * if they are the same or not. 
 * Two binary trees are considered the same 
 * if they are structurally identical and the nodes 
 * have the same value.
 * @author xwang
 *
 */
public class SameTree100 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && 
				isSameTree(p.right, q.right);
	}
	
	@Test
	public void test() {
		TreeNode p = new TreeNode(1), node2 = new TreeNode(2), 
				node3 = new TreeNode(3);
		p.left = node2;
		p.right = node3;
		TreeNode q = new TreeNode(1), node2_q = new TreeNode(2),
				node3_q = new TreeNode(3);
		q.left = node2_q;
		q.right = node3_q;
		System.out.println("IsSameTree: " + isSameTree(p, q));
	}
}
