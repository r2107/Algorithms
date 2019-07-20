package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;
public class MinimumSumDiffPartitionOfArray {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    int sum = 0;
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		        sum += arr[i];
		    }
		    int dp[][] = new int[n][sum + 1];
		    for(int i = 0; i < n; i++){
		        Arrays.fill(dp[i], -1);
		    }
		    int ans = fun(arr, dp, 0, 0, sum);
		    System.out.println(ans);
		    
		}
	}
	static int fun(int arr[], int dp[][], int i, int s1, int sum){
	    if(i >= arr.length){
	        int op = Math.max(sum - s1 - s1, s1 - sum + s1);
	        //if(op < ans) ans = op;
	        return op;
	    }
	    if(dp[i][s1] != -1) return dp[i][s1];
	    int op1 = fun(arr, dp, i + 1, s1 + arr[i], sum);
	    int op2 = fun(arr, dp, i + 1, s1, sum);
	    return dp[i][s1] = Math.min(op1, op2);
	}
}
/*
Input:
2
4
1 6 5 11
4
36 7 46 40

Output : 
1
23
*/