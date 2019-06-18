package StringsAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FormPalindrome {
	// minimum number of characters to be inserted to convert it to palindrome.
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    String a = s.next();
		    int n = a.length();
		    int dp[][] = new int[n][n];
		    for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
		    System.out.println(find(a, 0, a.length() - 1, dp));
		}
	}
	static int find(String a, int l, int r, int dp[][]) {
		if(l > r) return Integer.MAX_VALUE;
		if(l == r) return 0;
		if (l == r - 1) return (a.charAt(l) == a.charAt(r))? 0 : 1;
		if(dp[l][r] != -1) return dp[l][r];
		if(a.charAt(l) == a.charAt(r)) {
			return dp[l][r] = find(a, l + 1, r - 1, dp);
		}
		return dp[l][r] = Math.min(find(a, l + 1, r, dp), find(a, l, r - 1, dp)) + 1;
		
	}
}
