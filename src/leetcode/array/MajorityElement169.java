package leetcode.array;

import org.junit.jupiter.api.Test;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * @author xwang
 *
 */
public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		int counter = 0, res = 0;
		for (int val : nums) {
			if (counter == 0) {
				res = val;
				counter = 1;
			} else if (res == val) {
				counter ++;
			} else {
				counter --;
			}
		}
		return res;
	}
	
	
	@Test
	public void test() {
		int[] nums = {1,1,1,2,2,2,2};
		System.out.println("Majority: " + majorityElement(nums));
	}
}
