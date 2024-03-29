package leetcode.math;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i ++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			} else if (i % 3 == 0) {
				res.add("Fizz");
			} else if (i % 5 == 0) {
				res.add("Buzz");
			} else {
				res.add(i + "");
			}
		}
		System.out.println(res);
		return res;
	}
	
	@Test
	public void test() {
		System.out.println(fizzBuzz(15));
	}
}
