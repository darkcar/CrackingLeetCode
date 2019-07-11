package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CombinationSumII040 {
	/**
	 * [10, 1, 2, 7, 6, 1, 5]
	 * target: 8
	 * Let's sort it first 
	 * 1, 1, 2, 5, 6, 7, 10
	 * 1
	 * 1, 1
	 * 1, 1, 2
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		helper(candidates, target, 0, target, new ArrayList<Integer>());
		return res;
	}
	
	private void helper(int[] candidates, int remaining, int start, int target, List<Integer> tmpList) {
		if (remaining < 0) {
			return;
		} else if (remaining == 0) {
			res.add(new ArrayList<Integer>(tmpList));
		} else {
			for (int i = start; i < candidates.length; i ++) {
				if (i > start && candidates[i] == candidates[i - 1]) continue;
				if (target < candidates[i]) break;
				tmpList.add(candidates[i]);
				helper(candidates, remaining - candidates[i], i + 1, target, tmpList);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}
	
	@Test
	public void test() {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		Arrays.sort(candidates);
		System.out.println(combinationSum2(candidates, target));
	}
}
