package Backtracking;

import java.util.*;
public class RateInAMaze {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<String> res=g.printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}
}
class GfG{
     public static ArrayList<String> printPath(int[][] m, int n)
     {
         ArrayList<String> ans = new ArrayList<>();
         boolean b[][] = new boolean[n][n];
         b[0][0] = true;
         fun(ans, "", 0, 0, n, b, m);
         return ans;
     }
     static int y[] = {0, -1, 1, 0};
     static int x[] = {1, 0, 0, -1};
     static char d[] = {'D', 'L', 'R', 'U'};
     static void fun(ArrayList<String> ans, String str, int r, int c, int n, boolean b[][], int [][]m){
         if(r == n - 1 && c == n - 1){
             ans.add(str);
             return;
         }
         b[r][c] = true;
         for(int i = 0; i < 4; i++){
             int nx = r + x[i];
             int ny = c + y[i];
             if(valid(nx, ny, n) && !b[nx][ny] && m[nx][ny] == 1){
                 //b[nx][ny] = true;
                 fun(ans, str + "" + d[i], nx, ny, n, b, m);
                 //b[nx][ny] = false;
             }
         }
         b[r][c] = false;
         
     }
     static boolean valid(int nx, int ny, int n){
         if(nx >= 0 && ny >= 0 && ny < n && nx < n) return true;
         return false;
     }
}
/*
Input:
2
4
1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1
4
1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1
Output:
DRDDRR
DDRDRR DRDDRR
*/