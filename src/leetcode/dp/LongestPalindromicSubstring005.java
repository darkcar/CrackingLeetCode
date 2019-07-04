package leetcode.dp;

/**
 * Give a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * @author xwang
 *
 */
public class LongestPalindromicSubstring005 {
	/**
	 * Input: babad
	 * Output: bab
	 * dp[i][j]: the longest palindromic substring from i to j.
	 * dp[i][j] = dp[i + 1][j - 1]; if s[i] == s[j]
	 * dp[i][j] = false; if s[i] != s[j]
	 * dp[i][i] = true;
	 * dp[i][i - 1] = false;
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null) {return null;}
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i ++) {
			dp[i][i] = true;
		}
		
		for (int i = 0; i < len - 1; ++ i) {
			for (int j = i + 1; j < len; ++ j) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}
		
		for (int i = len - 1; i >= 0; -- i) {
			for (int j = 0; j < len; j ++) {
				if (dp[i][j]) {
					return s.substring(i, j + 1);
				}
			}
		}
		return null;
	}
}
