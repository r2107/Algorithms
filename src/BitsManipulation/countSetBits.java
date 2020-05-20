package BitsManipulation;

import java.util.*;

public class countSetBits {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		

	}
	
	// Brian Kernighan’s Algorithm:
	public static int countSet(int n) {
		int c = 0;
		while(n > 0) {
			n = n & (n - 1); // shifting n directly to next set bit instead of dividing it by 2 as we do in normal aprch.
			c++;
		}
		return c;
	}
	
	// lookup table
	static int bit[] = new int[256];
	{
		for(int i = 0; i < 256; i++) {
			bit[i] = i & 1 + bit[i * 2];
		}
		System.out.println(bit[5]);
	}
	public static int countLook(int n) {
		return bit[n & 255] + bit[(n >> 8) & 255] + bit[(n >> 16) & 255] + bit[n >> 24];
	}

}
