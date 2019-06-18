package StringsAlgorithms;

import java.util.*;

public class SortingAString {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		System.out.println(new String(arr));
	}
	
}
