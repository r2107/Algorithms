package BitsManipulation;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxXORSubset {
	public static void main(String[] args) throws IOException {
		// Reader s = new Reader();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(maxSubarrayXOR(arr, n));

		}
	}
	// from geeksforgeeks
	static int maxSubarrayXOR(int set[], int n) {
		// Initialize index of
		// chosen elements
		int index = 0;

		// Traverse through all
		// bits of integer
		// starting from the most
		// significant bit (MSB)
		for (int i = 32 - 1; i >= 0; i--) {
			// Initialize index of
			// maximum element and
			// the maximum element
			int maxInd = index;
			int maxEle = Integer.MIN_VALUE;
			for (int j = index; j < n; j++) {

				// If i'th bit of set[j]
				// is set and set[j] is
				// greater than max so far.
				if ((set[j] & (1 << i)) != 0 && set[j] > maxEle) {
					maxEle = set[j];
					maxInd = j;
				}
			}

			// If there was no
			// element with i'th
			// bit set, move to
			// smaller i
			if (maxEle == -2147483648)
				continue;

			// Put maximum element
			// with i'th bit set
			// at index 'index'
			int temp = set[index];
			set[index] = set[maxInd];
			set[maxInd] = temp;

			// Update maxInd and
			// increment index
			maxInd = index;

			// Do XOR of set[maxIndex]
			// with all numbers having
			// i'th bit as set.
			for (int j = 0; j < n; j++) {

				// XOR set[maxInd] those
				// numbers which have the
				// i'th bit set
				if (j != maxInd && (set[j] & (1 << i)) != 0)
					set[j] = set[j] ^ set[maxInd];
			}

			// Increment index of
			// chosen elements
			index++;
		}

		// Final result is
		// XOR of all elements
		int res = 0;
		for (int i = 0; i < n; i++)
			res ^= set[i];
		return res;
	}
}