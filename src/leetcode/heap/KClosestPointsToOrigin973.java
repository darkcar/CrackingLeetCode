package leetcode.heap;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * We have a list of points on the plane. Find the K closest points to origin.
 * Euclidean Distance: the straight-line distance between two points.
 * 
 * @author xwang
 *
 */
public class KClosestPointsToOrigin973 {
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
				(a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

		for (int[] point : points) {
			heap.add(point);
		}

		int[][] res = new int[K][2];
		int index = 0;
		while (K > 0) {
			res[index ++] = heap.poll();
			K --;
		}
		return res;

	}

	@Test
	public void test() {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { 11, 10 } };
		int K = 2;
		kClosest(points, K);
	}
}
