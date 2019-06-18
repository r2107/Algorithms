package StringsAlgorithms;

import java.util.*;

public class PermutationsInLexogOrder {
	// sorting the array from l to r
	static String sort(String str, int l, int r) {
		char arr[] = str.substring(l, r + 1).toCharArray();
		Arrays.sort(arr);
		String ans = str.substring(0, l);
		for(char i : arr) ans = ans + "" + i;
		return ans;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			String a = s.next();
			int n = a.length();
			// first permutation
			String B  = sort(a, 0, n - 1);
			//System.out.println(B);
			while(true) {
				System.out.print(a + " ");
				// find next higher permutation
				int i = n - 2;
				while(i >= 0 && a.charAt(i) > a.charAt(i + 1)) i--;
				if(i == -1) break; // last permutation printed as string now is reversly sorted
				else {
					int index = find(a, a.charAt(i), i + 1, n - 1);
					a = swap(a, index, i);
					a = sort(a, i + 1, n - 1);
				}
				
			}
		}

	}
	private static String swap(String a, int index, int i) {
		// as index is always > i
		return new String(a.substring(0, i) + a.charAt(index) + 
				a.substring(i + 1, index) + a.charAt(i) + a.substring(index + 1, a.length()));
	}
	// finds the index of char which is just greater than c from index l to r
	private static int find(String a, char c, int l, int r) {
		int min = l;
		for(int i = l + 1; i <= r; i++) {
			if(c < a.charAt(i) && a.charAt(i) < a.charAt(min)) min = i;
		}
		return min;
	}

}
