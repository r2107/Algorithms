package BitsManipulation;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CountTotalSetBits1toN {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    System.out.println(fun(n));
		    
		}
	}
	static int fun(int n){
	    if(n == 0) return 0;
	    int m = lmb(n);
	    return (n - (1 << m) + 1) + ((m) * (int)Math.pow(2, m - 1)) + fun(n - (1 << m));
	}
	static int lmb(int n){
	    int m = 0; 
        while (n > 1) { 
            n = n >> 1; 
            m++; 
        }    
        return m; 
	}
}
/*
Input:
2
4
17
Output:
5
35
*/