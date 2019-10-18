package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class GroupAnagram049 {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] chs = strs[i].toCharArray();
			String sbefore = String.valueOf(chs);
			Arrays.sort(chs);
			String sAfter = String.copyValueOf(chs);
			if (!map.containsKey(sAfter)) {
				List<String> list = new ArrayList<String>();
				list.add(sbefore);
				map.put(sAfter, list);
			} else {
				map.get(sAfter).add(sbefore);
			}
		}
		return new ArrayList<>(map.values());
	}

	@Test
	public void test() {
		String[] strs = {
				"eat", "tea", "tan", "ate", "nat", "bat"
		};
		System.out.print(strs);
		groupAnagrams(strs);
	}
}
