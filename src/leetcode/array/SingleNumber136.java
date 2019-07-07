package leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * Given a non-empty array of integers, every element appears twice 
 * except for one. Find the single one. 
 * @author xwang
 *
 */
public class SingleNumber136 {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}
	
	@Test
	public void test() {
		int[] nums = {2, 2, 1};
		int res = singleNumber(nums);
		System.out.println(res);
	}
}
