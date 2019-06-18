package StringsAlgorithms;

import java.util.*;
class Pair{
	int i, size;
}
public class LongestPalindromeSubString {
	static void findINN2(String a) {
		int n = a.length();
		int max = 1, index = 0;
		for(int i = 1; i < n; i++) {
			int low = i - 1, high = i + 1;
			while(low >= 0 && high < n && a.charAt(low) == a.charAt(high)) {
				low--; high++;
			}
			low++; high--;
			if(high - low + 1 > max) {
				max = high - low + 1;
				index = low;
			}
			low = i - 1; high = i;
			while(low >= 0 && high < n && a.charAt(low) == a.charAt(high)) {
				low--; high++;
			}
			low++;high--;
			if(high - low + 1 > max) {
				max = high - low + 1;
				index = low;
			}
		}
		System.out.println(a.substring(index, index + max));
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			String a = s.next();
			int n = a.length();
			// n ^ 2 apprch
			findINN2(a);
			// manchaesters algorithms for O(n)
			// soon todo
			
		}

	}

	

}
