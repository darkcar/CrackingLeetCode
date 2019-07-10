package leetcode.dp;

import org.junit.jupiter.api.Test;

public class EditDistance72 {
	/**
	 * dp[i][j]: the min distance from word1 ith char to word2 jth char. if
	 * word1.charAt(i) == word2.charAt(j), dp[i-1][j-1] if word1.charAt(i) !=
	 * word2.charAt(j), dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1],
	 * dp[i-1][j-1]) res = dp[i][j]
	 * horse - h -> r; rm r, e 
	 * ros
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		// corner case
		if (word1 == null || word2 == null) {
			return 0;
		}
		int len1 = word1.length();
		int len2 = word2.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		
		// if any word is empty string, how many steps needed
		for (int i = 0; i < len1 + 1; i ++) {
			dp[i][0] = i;
		}
		
		for (int j = 0; j < len2 + 1; j ++) {
			dp[0][j] = j;
		}
		
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(
							Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}
		return dp[len1][len2];
	}

	@Test
	public void test() {
		String word1 = "horse";
		String word2 = "ros";
		int res = minDistance(word1, word2);
		System.out.println(res);
	}
}
