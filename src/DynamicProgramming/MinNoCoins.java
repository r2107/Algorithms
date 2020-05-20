package DynamicProgramming;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Triplet{
    int x, y, vl;
    Triplet(int a, int b, int c){
        x = a; y = b; vl = c;
    }
}
public class MinNoCoins {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int val[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		    int m = val.length;
		    Triplet dp[][] = new Triplet[10][n + 1];
		    for(int i = 0; i < m; i++){
		        for(int j = 0; j <= n; j++){
		            dp[i][j] = new Triplet(0, 0, 0);
		        }
		    }
		    for(int i = 0; i <= n; i++){
		        dp[0][i].x = 0;
		        dp[0][i].y = i - 1;
		        dp[0][i].vl = i;
		    }
		    for(int i = 1; i < m; i++){
		        for(int j = 0; j <= n; j++){
		            int op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
		            if(j - val[i] >= 0){
		                op1 = dp[i - 1][j - val[i]].vl + 1;
		                op2 = dp[i][j - val[i]].vl + 1;
		            }
		            dp[i][j].vl = Math.min(dp[i - 1][j].vl, Math.min(op1, op2));
		            if(dp[i][j].vl == op1){
		                dp[i][j].x = i - 1;
		                dp[i][j].y = j - val[i];
		            }
		            else if(dp[i][j].vl == op2){
		                dp[i][j].x = i;
		                dp[i][j].y = j - val[i];
		            }
		            else{
		                dp[i][j].x = i - 1;
		                dp[i][j].y = j;
		            }
		        }
		    }
		    int px = m - 1;
		    int py = n;
		    int nx = dp[m - 1][n].x;
		    int ny = dp[m - 1][n].y;
		    /*for(int i = 0; i < m; i++){
		        for(int j = 0; j <= n; j++){
		            System.out.print(dp[i][j].vl + " ");
		        }
		        System.out.println();
		    }*/
		    int sum = 0;
		    while(true){
		        if(ny != py){
		            System.out.print(val[px] + " ");
		            sum += val[px];
		            if(sum == n) break;
		        }
		        px = nx;
		        py = ny;
		        nx = dp[px][py].x;
		        ny = dp[px][py].y;
		        
		    }
		    System.out.println();//dp[m - 1][n].vl
		}
	}
}
