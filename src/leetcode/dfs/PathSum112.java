package leetcode.dfs;

import org.junit.jupiter.api.Test;

public class PathSum112 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * Give a binary tree and a sum, determine if the tree has a root-to-leaf path
	 * @param root
	 * @param sum
	 * @return
	 */
	private boolean flag = false;
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
        helper(root, root.val, sum);
        return flag;
    }
    
    private void helper(TreeNode root, int res, int sum) {
        if (root.left == null && root.right == null && res == sum) {
            flag = true;
            return;
        }
        if (root.left != null) {
            helper(root.left, res + root.left.val, sum);
        }
        if (root.right != null) {
            helper(root.right, res + root.right.val, sum);
        }
    }
    
    /**
     * Test 
     */
    @Test
    public void test() {
    	TreeNode root = new TreeNode(5), node4 = new TreeNode(4), 
    			node8 = new TreeNode(8), node11 = new TreeNode(11),
    			node13 = new TreeNode(13), node4_2 = new TreeNode(4),
    			node7 = new TreeNode(7), node2 = new TreeNode(2),
    			node1 = new TreeNode(1);
    	root.left = node4;
    	root.right = node8;
    	node4.left = node11;
    	node8.left = node13;
    	node8.right = node4_2;
    	node11.left = node7;
    	node11.right = node2;
    	node4_2.right = node1;
    	int sum = 22;
    	hasPathSum(root, sum);
    }
}
