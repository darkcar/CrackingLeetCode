package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Permutations046 {
	public List<List<Integer>> permute(int[] nums) {
		helper(nums, nums.length);
		return res;
	}
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	private void helper(int[] nums, int k) {
		if (k == 1) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i ++) {
				list.add(nums[i]);
			}
			res.add(list);
		}
		
		for (int i = 0; i < k; i ++) {
			int tmp = nums[i];
			nums[i] = nums[k - 1]; 
			nums[k - 1] = tmp;
			
			helper(nums, k - 1);
			tmp = nums[i];
			nums[i] = nums[k - 1];
			nums[k - 1] = tmp;
		}
	}
	
	@Test
	public void test() {
		int[] nums = {1 ,2 ,3, 4};
		System.out.println(permute(nums));
	}
}
