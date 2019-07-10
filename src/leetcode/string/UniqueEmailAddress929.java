package leetcode.string;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class UniqueEmailAddress929 {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<String>();
		for (String email : emails) {
			int i = email.indexOf("@");
			String local = email.substring(0, i);
			String rest = email.substring(i);
			if (local.contains("+")) {
				local.substring(0, local.indexOf("+"));
			}
			local = local.replaceAll(".", "");
			set.add(local +  rest);
		}
		return set.size();
	}
	
	@Test
	public void test() {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int res = numUniqueEmails(emails);
		
		System.out.println("Number: " + res);
	}
}
