package leetcode.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given a binary tree, find its maximum depth. 
 * The maximum depth is the number of nodes along 
 * the longest path from the root node down to the farthest leaf node.
 * @author xwang
 *
 */
public class MaximumDepthBinaryTree104 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(3), node9 = new TreeNode(9), node20 = new TreeNode(20), 
				node15 = new TreeNode(15), node7 = new TreeNode(7);
		root.left = node9;
		root.right = node20;
		node20.left = node15;
		node20.right = node7;
		
		System.out.println("MaxDepth: " + maxDepth(root));
	}
}
