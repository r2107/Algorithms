package Backtracking;
import java.util.*;
import java.lang.*;
import java.io.*;
public class NQueenProblem {
	static boolean ans = false;
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int board[][] = new int[n][n];
		    print(board, n, 0);
		    if(!ans) System.out.println(-1);
		    else System.out.println();
		}
	}
	static boolean valid(int board[][], int r, int c){
		int n = board.length;
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < n; j++){
	            if(board[i][j] == 1){
	                if(i == r || j == c || i + j == r + c || j - i == c - r){
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
	static void pri(int [][] board){
		ans = true;
	    System.out.print("[");
	    int n = board.length;
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < n; j++){
	            if(board[i][j] == 1)
	                System.out.print((j + 1) + " ");
	        }
	    }
	    System.out.print("]");
	}
	static void print(int board[][], int n, int r){
	    if(r == n){
	        pri(board);
	        return;
	    }
	    for(int i = 0; i < n; i++){
	        if(valid(board, r, i)){
	            board[r][i] = 1;
	            print(board, n, r + 1);
	            board[r][i] = 0;
	        }
	    }
	    
	}
}