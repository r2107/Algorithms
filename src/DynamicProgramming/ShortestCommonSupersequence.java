package DynamicProgramming;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestCommonSupersequence {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    String a = s.next();
		    String b = s.next();
		    int dp[][] = new int[a.length() + 1][b.length() + 1];
		    for(int i = 0; i < a.length(); i++){
		        Arrays.fill(dp[i], -1);
		    }
		    // memoization
		    //System.out.println(fun(a, b, 0, 0, dp));
		    //dp
		    int n = a.length(), m = b.length();
		    // filling 0th col
		    for(int i = 0; i <= n; i++){
		        dp[i][0] = i;
		    }
		    // filling 0th row
		    for(int i = 0; i <= m; i++){
		        dp[0][i] = i;
		    }
		    for(int i = 1; i <= n; i++){
		        for(int j = 1; j <= m; j++){
		            int op3 = Integer.MAX_VALUE - 5;
		            if(a.charAt(i - 1) == b.charAt(j - 1)){
		                op3 = dp[i - 1][j - 1];
		            }
		            int op1 = dp[i][j - 1];
		            int op2 = dp[i - 1][j];
		            dp[i][j] = Math.min(Math.min(op1, op2), op3) + 1;
		        }
		    }
		    System.out.println(dp[n][m]);
		}
	}
	static int fun(String a, String b, int i, int j, int dp[][]){
	    if(a.length() == i){
	        return b.length() - j;
	    }
	    if(b.length() == j){
	        return a.length() - i;
	    }
	    if(dp[i][j] != -1) return dp[i][j];
	    int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
	    int op3 = Integer.MAX_VALUE;
	    if(a.charAt(i) == b.charAt(j)){
	        op1 = fun(a, b, i + 1, j + 1, dp);
	    }
	    op2 = fun(a, b, i + 1, j, dp);
	    op3 = fun(a, b, i, j + 1, dp);
	    return dp[i][j] = Math.min(op1, Math.min(op2, op3)) + 1;
	}
}