package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestIncreasingSubsequence {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }
		    int dp[] = new int[n];
		    Arrays.fill(dp, 1);
		    int max = 1;
		    for(int i = 1; i < n; i++){
		        for(int j = i - 1; j >= 0; j--){
		            if(arr[j] < arr[i]){
		                dp[i] = Math.max(dp[i], dp[j] + 1);
		            }
		        }
		        if(max < dp[i]) max = dp[i];
		    }
		    System.out.println(max);
		}
	}
}
/*
Input
2
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
6
5 8 3 7 9 1
Output
6
3
*/