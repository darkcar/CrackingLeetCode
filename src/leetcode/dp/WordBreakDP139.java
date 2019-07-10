package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordBreakDP139 {
	// dp[i]: the words from 0 to i are in the dict.
	// dp[i] = true, if 
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i ++) {
			for (int j = 0; j < i; j ++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	@Test
	public void test() {
		String s = "aaaaaaaaaaaaaaaaab";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		System.out.println(wordBreak(s, wordDict));
	}
}
