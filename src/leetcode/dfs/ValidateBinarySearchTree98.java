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
public class ValidateBinarySearchTree98 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		
	}
	
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(2), node1 = new TreeNode(1), node3 = new TreeNode(3);
		root.left = node1;
		root.right = node3;
		System.out.println("isValidBST: " + isValidBST(root));
	}
}
