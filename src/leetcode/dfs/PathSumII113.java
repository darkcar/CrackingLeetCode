package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * @author xwang
 *
 */
public class PathSumII113 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
        	return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        helper(root, root.val, sum, list);
        return res;
    
	}
	
	private void helper(TreeNode root, int tmp, int sum, List<Integer> list) {
		// Corner case or termination condition
		if (root.left == null && root.right == null && tmp == sum) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		// Loop all the possibilities 
		if (root.left != null) {
			list.add(root.left.val);
			helper(root.left, tmp + root.left.val, sum, list);
			list.remove(list.size() - 1);
		}
		if (root.right != null) {
			list.add(root.right.val);
			helper(root.right, tmp + root.right.val, sum, list);
			list.remove(list.size() - 1);
		}
	}
	
	@Test
    public void test() {
    	TreeNode root = new TreeNode(5), node4 = new TreeNode(4), 
    			node8 = new TreeNode(8), node11 = new TreeNode(11),
    			node13 = new TreeNode(13), node4_2 = new TreeNode(4),
    			node7 = new TreeNode(7), node2 = new TreeNode(2),
    			node1 = new TreeNode(1), node5 = new TreeNode(5);
    	root.left = node4;
    	root.right = node8;
    	node4.left = node11;
    	node8.left = node13;
    	node8.right = node4_2;
    	node11.left = node7;
    	node11.right = node2;
    	node4_2.right = node1;
    	node4_2.left = node5;
    	int sum = 22;
    	pathSum(root, sum);
	}
	
}
