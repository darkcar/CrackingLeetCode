package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WordBreakBruteForce139 {
	/**
	 * Brute Force
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		return isWordBreak(s, wordDict, 0);
	}
	
	private boolean isWordBreak(String s, List<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int end = start + 1; end <= s.length(); end ++) {
			if (wordDict.contains(s.substring(start, end)) && isWordBreak(s, wordDict, end)) {
				return true;
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
		System.out.println(wordBreak(s, wordDict));
	}
}
