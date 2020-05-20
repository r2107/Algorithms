package BitsManipulation;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SwapAllOddEvenBits {
	public static void main(String[] args) throws IOException {
		// Reader s = new Reader();
		//System.out.println(0xAA);
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			int ans1 = (n << 1) & 170;
			int ans2 = (n >> 1) & 85;
			System.out.println(ans1 | ans2);
			//System.out.println(swapBits(n));
		}

	}

	static int swapBits(int x) {
		// Get all even bits of x
		int even_bits = x & 0xAAAAAAAA;
		// Get all odd bits of x
		int odd_bits = x & 0x55555555;
		// Right shift even bits
		even_bits >>= 1;
		// Left shift even bits
		odd_bits <<= 1;
		// Combine even and odd bits
		return (even_bits | odd_bits);
	}
}