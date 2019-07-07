package leetcode.array;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Given an array of integers, return indices of the two numbers 
 * 	such that they add up to a specific target. 
 * You may assume that each input would have exactly one solution, 
 * 	and you may not use the same element twice.
 * @author xwang
 *
 */
public class TwoSum001 {
	
	public int[] twoSum(int[] nums, int target) {
		// 1. Brute force O(n^2)
		// 2. HashMap: O(n);
		if (nums == null) return null;
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i ++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target-nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	@Test
	public void test() {
		int[] nums = {2, 7, 11, 15};
		int target = 13;
		int[] res = twoSum(nums, target);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
