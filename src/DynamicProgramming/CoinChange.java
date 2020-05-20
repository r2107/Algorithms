package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;
public class CoinChange {
	public static void main (String[] args){
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }
		    int m = s.nextInt();
		    int dp[][] = new int[n][m + 1];
		    for(int i = 0; i <= m; i++){
		        if(arr[0] < i) dp[0][i] = dp[0][i - arr[0]];
		        else if(arr[0] == i) dp[0][i]++;
		    }
		    for(int i = 1; i < n; i++){
		        for(int j = 0; j <= m; j++){
		            int op1 = dp[i - 1][j];
		            int op2 = 0, op3 = 0, op4 = 0;
		            if(arr[i] <= j){
		                op2 = dp[i - 1][j - arr[i]];
		                op3 = dp[i][j - arr[i]];
		                if(arr[i] == j) op4 = 1;
		            }
		            dp[i][j] = Math.max(op2, op3) + op4 + op1;
		        }
		    }
		    System.out.println(dp[n - 1][m]);
		}
	}
}
/*
Input:
2
3
1 2 3
4
4
2 5 3 6
10
Output:
4
5
Explanation:
Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.
*/