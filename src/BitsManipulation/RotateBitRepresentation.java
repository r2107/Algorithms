package BitsManipulation;

import java.util.*;
import java.lang.*;
import java.io.*;
public class RotateBitRepresentation {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int d = s.nextInt();
		    int arr[] = new int[16];
		    int i = 0;
		    while(n > 0){
		        arr[i++] = n % 2;
		        n /= 2;
		    }
		    System.out.println(left(arr, d, n));
		    System.out.println(right(arr, d, n));
		    
		}
	}
	static int left(int arr[], int d, int n){
		/*
	    int ans = 0;
	    for(int i = 0; i < 16; i++){
	        ans += arr[i] * Math.pow(2, (i + d)%16);
	    }
	    return ans;*/
		return (n << d) | (n >> (16 - d));
	}
	static int right(int arr[], int d, int n){
		/*
	    int ans = 0;
	    for(int i = d; i < 16 + d; i++){
	        ans += arr[i%16] * Math.pow(2, (i - d));
	    }
	    return ans;*/
		return (n >> d) | (n << (16 - d));
	}
}