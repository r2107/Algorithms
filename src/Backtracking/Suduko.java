package Backtracking;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Suduko {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    //int n = s.nextInt();
		    int arr[][] = new int[9][9];
		    for(int i = 0; i < 9; i++){
		        for(int j = 0; j < 9; j++){
		            arr[i][j] = s.nextInt();
		        }
		    }
		    if(fun(arr)) {
		    	print(arr);
		    }
		    else {
		    	System.out.println(-1);
		    }
		}
	}
	static int x[] = {0, 1, 0, -1};
	static int y[] = {1, 0, -1, 0};
	static boolean fun(int arr[][]){
		int row = -1, col = -1;
		boolean b = true;
	    for(int i = 0; i < 9; i++) {
	    	for(int j = 0; j < 9; j++) {
	    		if(arr[i][j] == 0) {
	    			row = i; col = j;
	    			b = false;
	    			break;
	    		}
	    	}
	    	if(!b) break;
	    }
	    if(b) return true;
	    for(int i = 1; i <= 9; i++) {
	    	arr[row][col] = i;
	    	if(valid1(row, col, arr)) {
	    		if(fun(arr)) return true;
	    	}
	    	arr[row][col] = 0;
	    }
	    return false;
	    
	}
	private static boolean valid1(int r, int c, int[][] arr) {
		return row(arr, r) & col(arr, c) & sub(arr, r, c);
	}
	private static boolean valid(int nx, int ny) {
		if(nx >= 0 && ny >= 0 && nx < 9 && ny < 9) {
			return true;
		}
		return false;
	}
	private static boolean sub(int[][] arr, int nx, int ny) {
		int lr = (nx / 3) * 3, lc = (ny / 3) * 3;
		int []m = new int[10];
		for(int i = lr; i < lr + 3; i++) {
			for(int j = lc; j < lc + 3; j++) {
				if(arr[i][j] != 0 && m[arr[i][j]] != 0) {
					return false;
				}
				else if(arr[i][j] != 0) {
					m[arr[i][j]]++;
				}
			}
		}
		return true;
	}
	private static boolean col(int[][] arr, int ny) {
		int []m = new int[10];
		for(int i = 0; i < 9; i++) {
			if(arr[i][ny] != 0 && m[arr[i][ny]] != 0) {
				return false;
			}
			else if(arr[i][ny] != 0) {
				m[arr[i][ny]]++;
			}
		}
		return true;
	}
	private static boolean row(int[][] arr, int nx) {
		int []m = new int[10];
		for(int i = 0; i < 9; i++) {
			if(arr[nx][i] != 0 && m[arr[nx][i]] != 0) {
				return false;
			}
			else if(arr[nx][i] != 0) {
				m[arr[nx][i]]++;
			}
		}
		return true;
	}
	private static void print(int[][] arr) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
/*
Input:
1
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1 
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
*/