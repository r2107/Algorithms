package StringsAlgorithms;

import java.util.*;

public class LongestCommonSubstring {
	// length of LCS
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			int n = s.nextInt();
			int m = s.nextInt();
			String a = s.next();
			String b = s.next();
			int dp[][][] = new int[n][m][101];
			for(int i = 0; i < n; i++){
			    for(int j = 0; j < m; j++){
			        Arrays.fill(dp[i][j], -1);
			    }
			}
			System.out.println(find(a, b, dp, 0, 0, 0));
		}

	}

	private static int find(String a, String b, int dp[][][], int i, int j, int count) {
		if(i >= a.length() || j >= b.length()) {
		    return count;
		}
		if(dp[i][j][count] != -1) return dp[i][j][count];
		int res = count;
		if(a.charAt(i) == b.charAt(j)) {
			res = Math.max(count, find(a, b, dp, i + 1, j + 1, count + 1));
		}
		int op2 = find(a, b, dp, i + 1, j, 0);
		int op3 = find(a, b, dp, i, j + 1, 0);
		return dp[i][j][count] = Math.max(res, Math.max(op2, op3));
	}


}
