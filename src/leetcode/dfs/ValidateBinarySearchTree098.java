package leetcode.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST). 
 * Assume a BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key. 
 *  The right subtree of a node contains only nodes with keys greater than the node's key. 
 *  Both the left and right subtrees must also be binary search trees.
 * @author xwang
 *
 */
public class ValidateBinarySearchTree098 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	private boolean isValid = true;
	private long tmpVal = Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		helper(root);
		return isValid;
	}
	
	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		if (tmpVal < root.val) {
			tmpVal = root.val;
		} else {
			isValid = false;
		}
		
		helper(root.right);
	}
	
	
	@Test
	public void test() {
		// TreeNode root = new TreeNode(1), node1 = new TreeNode(1), node3 = new TreeNode(3);
		TreeNode root = new TreeNode(1), node1 = new TreeNode(1);
		root.left = node1;
		System.out.println("isValidBST: " + isValidBST(root));
	}
}
