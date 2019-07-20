package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;
public class EditDistance {
	/*Given two strings str1 and str2 and below operations that can performed on str1.
	 *  Find minimum number of edits (operations) required to convert str1 into str2.
	Insert, Remove, Replace
	All of the above operations are of cost=1.
	Both the strings are of lowercase.*/
	public static void main (String[] args){
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int m = s.nextInt();
		    String a = s.next();
		    String b = s.next();
		    int dp[][] = new int[n + 1][m + 1];
		    for(int i = 0; i <= n; i++){
		        dp[i][0] = i;
		    }
		    for(int i = 0; i <= m; i++){
		        dp[0][i] = i;
		    }
		    for(int i = 1; i <= n; i++){
		        for(int j = 1; j <= m; j++){
		            int op1 = Integer.MAX_VALUE;
		            if(a.charAt(i - 1) == b.charAt(j - 1)){
		                op1 = dp[i - 1][j - 1];
		            }
		            int op2 = dp[i - 1][j] + 1;
		            int op3 = dp[i][j - 1] + 1;
		            int op4 = dp[i - 1][j - 1] + 1;
		            dp[i][j] = Math.min(Math.min(op1, op2), Math.min(op3, op4));
		        }
		    }
		    System.out.println(dp[n][m]);
		    
		}
	}
}
/*
Input
1
4 5
geek gesek
Output
1
*/