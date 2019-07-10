package leetcode.math;

import org.junit.jupiter.api.Test;

public class DistributeCandiesToPeople1103 {
	/**
	 * 7 candies ---> 4 people 
	 * 7 % 4 == 3
	 * 1, 2, 3, 1
	 * 
	 * 10 % 3 == 1
	 * 1, 2, 3, 
	 * @param candies
	 * @param num_people
	 * @return
	 */
	public int[] distributeCandies(int candies, int num_people) {
		int[] res = new int[num_people];
		/**
		 * 10 candies, num = 3 
		 * 1, 2, 3 = 6
		 * (3+1)   = 4 
		 */
		/**
		 * i = 0; candies = 10, num_people = 3 => res[0] = 1;
		 * i = 1; candies = 9, num_people = 3 => res[1] = 2;
		 * i = 3; candies = 7, num_people = 3 => res[2] = 3
		 * i = 0; candies = 4, num_people = 3 => res[0] = 4;
		 * 
		 */
		for (int i = 0; candies > 0; candies -= i) {
			res[i % num_people] += Math.min(candies, ++i);
		}
		
		return res;
	}
	
	@Test
	public void test() {
		System.out.print(distributeCandies(10, 3));
	}
}
