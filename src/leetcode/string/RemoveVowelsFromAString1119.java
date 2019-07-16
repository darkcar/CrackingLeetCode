package leetcode.string;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Easy
 * Given a string, remove 'a', 'e', 'i', 'o', 'u'.
 * @author k11237
 *
 */
public class RemoveVowelsFromAString1119 {
	
	/*
	 * Use Set stores the chars and use string builder to reconstruct the string
	 */
	public String removeVowels(String S) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		StringBuilder res = new StringBuilder();
		for (char c : S.toCharArray()) {
			if (!vowels.contains(c)) res.append(c);
		}
		return res.toString();
	}
	
	/*
	 * String pattern match
	 */
	public String removeVowels2(String S) {
		return S.replaceAll("a|e|i|o|u","");
	}
	
	@Test
	public void test() {
		String S = "leetcodeisacommunityforcoders";
		// System.out.println(removeVowels(S));
		System.out.println(removeVowels2(S));
	}
}
