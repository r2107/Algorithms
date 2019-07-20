package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestCommonSubsequence {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int m = s.nextInt();
		    String a = s.next();
		    String b = s.next();
		    int dp[][] = new int[n + 1][m + 1];
		    /*for(int i = 0; i <= n; i++){
		        dp[i][n] = 0;
		    }*/
		    for(int i = 0; i <= m; i++){
		        dp[0][i] = 0;
		    }
		    for(int i = 1; i <= n; i++){
		        for(int j = 1; j <= m; j++){
		            int op1 = Integer.MIN_VALUE;
		            if(a.charAt(i - 1) == b.charAt(j - 1)){
		                op1 = dp[i - 1][j - 1] + 1;
		            }
		            int op2 = dp[i - 1][j];
		            int op3 = dp[i][j - 1];
		            dp[i][j] = Math.max(op1, Math.max(op2, op3));
		        }
		    }
		    System.out.println(dp[n][m]);
		}
	}
}
/*
Input
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC
Output
3
2
*/