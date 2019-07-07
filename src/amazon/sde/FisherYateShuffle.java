package amazon.sde;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class FisherYateShuffle {
	public int[] shuffle(int[] nums) {
		if (nums == null) {return null;}
		int len = nums.length;
		int[] res = new int[len];
		for (int i = len; i > 1; -- i) {
			int j = new Random().nextInt(i);
			swap(i - 1, j, nums);
		}
		return res;
	}
	
	private void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	@Test 
	public void test() {
		int[] nums = {12, 29, 22, 10, 44, 99, 100, 32};
		shuffle(nums);
		for (int i : nums) {
			System.out.print(i + ", ");
		}
	}
}
