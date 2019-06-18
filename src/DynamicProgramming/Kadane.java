package DynamicProgramming;

import java.io.*;

public class Kadane {
	// finding the contiguous sub-array with maximum sum.
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(s.readLine());
		StringBuilder sb = new StringBuilder();
		while(t > 0){
		    t--;
		    int n = Integer.parseInt(s.readLine());
		    int arr[] = new int[n];
		    String line = s.readLine();
		    String str[] = line.trim().split("\\s+");
		    for(int i = 0; i < n; i++) {
		    	arr[i] = Integer.parseInt(str[i]);
		    }
		    // kadane algo
		    sb.append(kadane(arr) + "\n");
		}
		System.out.println(sb);
	}
	private static long kadane(int[] arr) {
		int n = arr.length;
		long currsum = 0;
		long max = Long.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			currsum += arr[i];
			if(currsum > max) {
				max = currsum;
			}
			if(currsum <= 0) {
				currsum = 0;
			}
		}
		return max;
	}

}
