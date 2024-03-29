package leetcode.dp;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Give a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * @author xwang
 *
 */
public class LongestPalindromicSubstring005 {
	/**
	 * Input: babad Output: bab dp[i][j]: the longest palindromic substring from i
	 * to j. dp[i][j] = dp[i + 1][j - 1]; if s[i] == s[j] dp[i][j] = false; if s[i]
	 * != s[j] dp[i][i] = true; dp[i][i - 1] = false;
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null) {
			return null;
		}
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		String res = "";
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		for (int i = len - 1; i >= 0; --i) {
			for (int j = i; j < len; ++j) {
				if (s.charAt(i) == s.charAt(j) && ((j - i < 3) || dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}
				if (dp[i][j] && (j - i + 1) > res.length()) {
					res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

	/**
	 * Method 2: Manacher Algorithm
	 */
	public String findLongest(String s) {
		if (s == null || s.length() == 0)
			return "";

		char[] s2 = addBoundaries(s.toCharArray());
		int[] p = new int[s2.length];
		int c = 0, r = 0; // Here the first element in s2 has been processed.
		int m = 0, n = 0; // The walking indices to compare if two elements are the same.
		for (int i = 1; i < s2.length; i++) {
			if (i > r) {
				p[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int i2 = c * 2 - i;
				if (p[i2] < (r - i - 1)) {
					p[i] = p[i2];
					m = -1; // This signals bypassing the while loop below.
				} else {
					p[i] = r - i;
					n = r + 1;
					m = i * 2 - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				p[i]++;
				m--;
				n++;
			}
			if ((i + p[i]) > r) {
				c = i;
				r = i + p[i];
			}
		}
		int len = 0;
		c = 0;
		for (int i = 1; i < s2.length; i++) {
			if (len < p[i]) {
				len = p[i];
				c = i;
			}
		}
		char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
		return String.valueOf(removeBoundaries(ss));
	}

	private char[] addBoundaries(char[] cs) {
		if (cs == null || cs.length == 0)
			return "||".toCharArray();

		char[] cs2 = new char[cs.length * 2 + 1];
		for (int i = 0; i < (cs2.length - 1); i = i + 2) {
			cs2[i] = '|';
			cs2[i + 1] = cs[i / 2];
		}
		cs2[cs2.length - 1] = '|';
		return cs2;
	}

	private char[] removeBoundaries(char[] cs) {
		if (cs == null || cs.length < 3)
			return "".toCharArray();

		char[] cs2 = new char[(cs.length - 1) / 2];
		for (int i = 0; i < cs2.length; i++) {
			cs2[i] = cs[i * 2 + 1];
		}
		return cs2;
	}

	@Test
	public void test() {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
}
