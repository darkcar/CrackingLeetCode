package leetcode.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given a binary tree, determine if it is height-balanced.
 * a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1
 * @author xwang
 *
 */
public class BalancedBinaryTree110 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private boolean isBalanced = false;
	public boolean isBalanced(TreeNode root) {
		if (root == null || root.left == null || root.right == null) {
			return true; 
		}
		helper(root.left, root.right, 1, 1);
		return isBalanced;
	}
	
	private void helper(TreeNode node1, TreeNode node2, int h1, int h2) {
		if (node1.left == null && node1.right == null && 
				node2.left == null && node2.right == null && Math.abs(h1-h2) <= 1) {
			isBalanced = true;
			return;
		}
		if (node1 != null) {
			h1 ++;
			if (node1.left != null) {
				helper(node1.left, node2, h1, h2);
			}
			if (node1.right != null) {
				helper(node1.right, node2, h1, h2);
			}
		}
		
		if (node2 != null) {
			h2 ++;
			if (node2.left != null) {
				helper(node1, node2.left, h1, h2);
			}
			if (node2.right != null) {
				helper(node1, node2.right, h1, h2);
			}
		}
	}
	
	@Test
	public void test() {
//		TreeNode root = new TreeNode(3), node9 = new TreeNode(9), node20 = new TreeNode(20),
//				node15 = new TreeNode(15), node7 = new TreeNode(7);
		
		TreeNode root = new TreeNode(1), node2 = new TreeNode(2), node2_r = new TreeNode(2),
				node3 = new TreeNode(3), node3_r = new TreeNode(3), node4 = new TreeNode(4),
				node4_r = new TreeNode(4);
		root.left = node2;
		root.right = node2_r;
		node2.left = node3;
		node2.right = node3_r;
		node3.left = node4;
		node3.right = node4_r;
		isBalanced(root);
		System.out.println("isBalanced: " + isBalanced);
	}
}

