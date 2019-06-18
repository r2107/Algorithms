package Sorting;
import java.util.*;
import java.lang.*;
import java.io.*;

class MergeingTwoSortedArrays {
	public static void main (String[] args) throws IOException{
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(s.readLine());
		StringBuilder sb = new StringBuilder();
		while(t > 0){
		    t--;
		    String l1 = s.readLine();
		    String s1[] = l1.trim().split("\\s+");
		    int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
		    int arr[] = new int[n];
		    String line1 = s.readLine();
		    String str[] = line1.trim().split("\\s+");
		    for(int i = 0; i < n; i++){
		        arr[i] = Integer.parseInt(str[i]);
		    }
		    int brr[] = new int[m];
		    String line2 = s.readLine();
		    String str2[] = line2.trim().split("\\s+");
		    for(int i = 0; i < m; i++){
		        brr[i] = Integer.parseInt(str2[i]);
		    }
		    
		    merge(arr, brr,n ,m);
		    for(int i = 0; i < n; i++){
		        sb.append(arr[i] + " ");
		    }
		    for(int i = 0; i < m; i++){
		        sb.append(brr[i] + " ");
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
	static int nextGap(int gap){
	    if(gap <= 1)
	        return 0;
	    return (gap / 2) + (gap % 2);
	}
	static void swap(int arr[], int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j]; arr[j] = temp;
	}
	static void merge(int arr[], int brr[], int n, int m){
	    int gap = nextGap(n + m);
	    for(int g = gap; g > 0; g = nextGap(g)){
	        int i;
	        for(i = 0; i + g < n; i++){
	            if(arr[i] > arr[i + g]){
	                swap(arr, i, i + g);
	            }
	        }
	        int j = g - n;
	        if(j < 0) j = 0;
	        for(; i < n && j < m; j++, i++){
	            if(arr[i] > brr[j]){
	                int temp = arr[i];
	                arr[i] = brr[j]; brr[j] = temp;
	            }
	        }
	        if(j < m){
    	        for(j = 0; j + g < m; j++){
    	            if(brr[j] > brr[j + g]){
    	                swap(brr, j, j + g);
    	            }
    	        }
	        }
	    }
	    
	}
}



