package leetcode.string;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Reverse only the vowels of a String 
 * @author k11237
 *
 *	Runtime: 10 ms, faster than 13.22% of Java online submissions 
 *		for Reverse Vowels of a String. 
 *	Memory Usage: 38.5 MB, less than 99.92% of 
 *		Java online submissions for Reverse Vowels of a String
 *
 */
public class RemoveVowelsOfaString345 {
	
	/*
	 * "hello"
	 * "holle"
	 * 
	 * "leetcode"
	 * "leotcede"
	 * 
	 */
	public String reverseVowels(String s) {
		if (s == null) return "";
		Set<Character> v = new HashSet<>();
		v.add('a');v.add('A');
		v.add('e');v.add('E');
		v.add('i');v.add('I');
		v.add('o');v.add('O');
		v.add('u');v.add('U');
		StringBuffer sb = new StringBuffer(s);
		int l = 0, r = sb.length() - 1;
		while (l <= r) {
			char chl = sb.charAt(l);
			char chr = sb.charAt(r);
			if (v.contains(chl) && v.contains(chr)) {
				sb.setCharAt(l, chr);
				sb.setCharAt(r, chl);
				l ++;
				r --;
			} else if (v.contains(chl) && !v.contains(chr)) {
				r --;
			} else if (!v.contains(chl) && v.contains(chr)) {
				l ++;
			} else {
				l ++;
				r --;
			}
		}
		return sb.toString();
	}
	
	
	public String reverseVowels2(String s) {
		if (s == null) return s;
		String vowels = "aeiouAEIOU";
		char[] vs = s.toCharArray();
		int l = 0; 
		int r = s.length() - 1;
		while (l <= r) {
			while (l <= r && !vowels.contains(vs[l] + "")) {
				l ++;
			} 
			while (l <= r && !vowels.contains(vs[r] + "")) {
				r --;
			}
			
			char t = vs[l];
			vs[l] = vs[r];
			vs[r] = t;
			l ++;
			r --;
		}
		return new String(vs);
	}
	
	@Test
	public void test() {
		String s = "leetcode";
		System.out.println(reverseVowels2(s));
	}
}
