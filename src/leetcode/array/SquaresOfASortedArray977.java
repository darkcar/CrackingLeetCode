package leetcode.array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SquaresOfASortedArray977 {
	public int[] sortedSquares(int[] A) {
		int[] res = new int[A.length];
		for (int i = 0; i < A.length; i ++) {
			res[i] = A[i] * A[i];
		}
		Arrays.sort(res);
		return res;
	}
	// O(nlogn)
	@Test
	public void test() {
		int[] A = {-4,-1,0,3,10};
		int[] res = sortedSquares(A);
		for (int v : res) {
			System.out.print(v + " ");
		}
	}
}
