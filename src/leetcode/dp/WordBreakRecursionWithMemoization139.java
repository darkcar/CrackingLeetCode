package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordBreakRecursionWithMemoization139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		return helper(s, wordDict, 0, new Boolean[s.length()]);
	}
	
	private boolean helper(String s, List<String> wordDict, int start, Boolean[] memo) {
		if (start == s.length()) {
			return true;
		}
		
		if (memo[start] != null) {
			return memo[start];
		}
		
		for (int end = start + 1; end <= s.length(); end ++) {
			if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end, memo)) {
				return memo[start] = true;
			}
		}
		return false;
	}
	
	@Test
	public void test() {
		String s = "aaaaaaaaaaaaaaaaab";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		System.out.print(wordBreak(s, wordDict));
	}
}
