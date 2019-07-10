package leetcode.string;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ReorderLogFiles937 {
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (a, b) -> {
			String[] aStrs = a.toString().split(" ");
			String[] bStrs = b.toString().split(" ");
			// if a is digit
			if (Character.isDigit(aStrs[1].charAt(0))) {
				if (Character.isDigit(bStrs[1].charAt(0))) {
					return 0;
				}
				return 1;
 			}
			
			// if a is letter-log, b is digit
			if (Character.isDigit(bStrs[1].charAt(0))) {
				return -1;
			}
			
			String x = a.substring(aStrs[0].length() + 1, a.length());
			String y = b.substring(bStrs[0].length() + 1, b.length());
			
			if (x.equals(y)) {
				return aStrs[0].compareTo(bStrs[0]);
			}
			return x.compareTo(y);
		});
		return logs;
	}
	
	@Test
	public void test() {
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String[] res = reorderLogFiles(logs);
		for (String s : res) {
			System.out.print(s + " ");
		}
	}
}
