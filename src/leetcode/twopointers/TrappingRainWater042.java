package leetcode.twopointers;

import org.junit.jupiter.api.Test;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of teach bar is 1, compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 * @author xwang
 *
 */
public class TrappingRainWater042 {
	public int trap(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int res = 0;
		int len = heights.length;
		int l = 0;
		int r = len - 1;
		int lb = heights[l]; // from the first one
		int rb = heights[r]; // from the last one

		while (l <= r) {
			if (lb < rb) {
				if (lb > heights[l]) {
					res += lb - heights[l];
				}
				lb = Math.max(lb, heights[l]);
				l++;
			} else {
				if (rb > heights[r]) {
					res += rb - heights[r];
				}
				rb = Math.max(rb, heights[r]);
				r--;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.print("Trapped water: " + trap(heights));
	}
}
