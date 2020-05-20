package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;
class Pa{
	int f; int s;
	Pa(){f = 0; s = 0;}
}
public class OptimalStrategyGame {
	/*You are given an array A of size N. The array contains integers and is of even length. 
	 The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.
	 In each turn, a player selects either the first or last coin from the row, 
	 removes it from the row permanently, and receives the value of the coin.
	 You need to determine the maximum possible amouint of money you can win if you go first.
	*/
	public static void main (String[] args) throws IOException{
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }
		    /* memoization
		    Pa dp[][][] = new Pa[n][n][3];
		    System.out.println(fun(arr, dp, 0, n - 1, 1).f);
		    */
		    // dp
		    int dp[][] = new int[n][n];
		    for(int gap = 0; gap < n; gap++) {
		    	for(int j = gap, i = 0; j < n; j++, i++) {
		    		int x = ((i + 2) <= j) ? dp[i + 2][j] : 0; 
		            int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0; 
		            int z = (i <= (j - 2)) ? dp[i][j - 2] : 0; 
		            dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
		    	}
		    }
		    System.out.println(dp[0][n - 1]);
		}
	}
	static Pa fun(int arr[], Pa dp[][][], int s, int e, int p){
	    if(s == e){
	    	Pa ans = new Pa();
	    	if(p == 1) ans.f = arr[s];
	    	else ans.s = arr[s];
	        return ans;
	    }
	    if(dp[s][e][p] != null) return dp[s][e][p];
	    if(p == 1){
	        Pa op1 = fun(arr, dp, s + 1, e, 2);
	        Pa op2 = fun(arr, dp, s, e - 1, 2);
	        Pa ans = new Pa();
	        if(op1.s < op2.s){
	            ans.s = op1.s;
	            ans.f = op1.f + arr[s];
	        }
	        else{
	            ans.s = op2.s;
	            ans.f = op2.f + arr[e];
	        }
	        return dp[s][e][p] = ans;
	    }
	    else{
	        Pa op1 = fun(arr, dp, s + 1, e, 1);
	        Pa op2 = fun(arr, dp, s, e - 1, 1);
	        Pa ans = new Pa();
	        if(op1.f < op2.f){
	            ans.s = op1.s + arr[s];
	            ans.f = op1.f;
	        }
	        else{
	            ans.s = op2.s + arr[e];
	            ans.f = op2.f;
	        }
	        return dp[s][e][p] = ans;
	    }    
	}
}
/*
 Input:
2
4
5 3 7 10
4
8 15 3 7
Output:
15
22
*/

