package DivideAndConquer;

import java.util.*;
import java.lang.*;
import java.io.*;
public class MiddleElementsOfTwoSortedArrays {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }
		    int brr[] = new int[n];
		    for(int i = 0; i < n; i++){
		        brr[i] = s.nextInt();
		    }
		    int i = 0, j = 0, m1 = -1, m2 = -1, k = 0;
		    while(k <= n){
		        if(i == n){
		            m1 = m2;
		            m2 = brr[0];
		            break;
		        }
		        if(j == n){
		            m1 = m2;
		            m2 = arr[0];
		            break;
		        }
		        if(arr[i] <= brr[j]){
		            m1 = m2;
		            m2 = arr[i]; i++;
		        }
		        else{
		            m1 = m2;
		            m2 = brr[j]; j++;
		        }
		        k++;
		    }
		    System.out.println(m1 + m2);
		}
	}
}