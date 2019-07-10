package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class WordBreakkBFS139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[s.length()];
		queue.add(0);
		while (!queue.isEmpty()) {
			int start = queue.poll();
			if (visited[start] == 0) {
				for (int end = start + 1; end <= s.length(); end ++) {
					if (wordDict.contains(s.substring(start, end))) {
						queue.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
				visited[start] = 1;
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
