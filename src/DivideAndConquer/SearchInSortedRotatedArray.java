package DivideAndConquer;

import java.util.*;
import java.lang.*;
import java.io.*;
public class SearchInSortedRotatedArray {
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
		    int x = s.nextInt();
		    int st = 0, e = n - 1;
		    int p = -1;
		    while(st <= e){
		        int mid = (st + e) / 2;
		        if(mid + 1 < n && arr[mid] > arr[mid + 1]){
		            p = mid;
		            break;
		        }
		        else if(mid - 1 >= 0 && arr[mid] < arr[mid - 1]){
		            p = mid - 1;
		            break;
		        }
		        else if(arr[st] > arr[mid]){
		            e = mid - 1;
		        }
		        else{
		            st = mid + 1;
		        }
		    }
		    //System.out.println(p);
		    if(p == -1){
		        System.out.println(fun(arr, 0, n - 1, x));
		    }
		    else{
		        if(arr[p] == x) System.out.println(p);
		        else if(x < arr[p] && x >= arr[0]){
		            System.out.println(fun(arr, 0, p - 1, x));
		        }
		        else{
		            System.out.println(fun(arr, p + 1, n - 1, x));
		        }
		    }
		    
		}
	}
	static int fun(int arr[], int s, int e, int x){
	    while(s <= e){
	       int mid = (s + e) / 2;
	       if(arr[mid] == x){
	           return mid;
	       }
	       else if(arr[mid] < x){
	           s = mid + 1;
	       }
	       else{
	           e = mid - 1;
	       }
	    }
	    return -1;
	}
}
/*
Input:
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6
Output:
5
1
-1
*/





