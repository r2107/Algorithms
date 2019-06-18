package StringsAlgorithms;

import java.util.Scanner;

public class MultiplyTwoStrings {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String b = s.nextLine();
		System.out.println(multiply(a, b));

	}
	static String multiply(String a, String b) {
		StringBuilder sb = new StringBuilder();
		boolean nega = false, negb = false;
		if (a.charAt(0) == '-') {
			a = a.substring(1);
			nega = true;
		}
		if (b.charAt(0) == '-') {
			b = b.substring(1);
			negb = true;
		}
		int n = a.length();
		int m = b.length();
		int arr[] = new int[n + m + 1];
		for (int i = m - 1; i >= 0; i--) {
			int x = b.charAt(i) - '0';
			multi(x, a, arr, m - 1 - i);
		}
		for (int i = 0; i < n + m; i++) {
			if (arr[i] > 9) {
				int temp = arr[i];
				arr[i] = arr[i] % 10;
				arr[i + 1] += temp / 10;
			}
		}
		int ans = -1;
		for (int i = n + m; i >= 0; i--) {
			if (arr[i] != 0) {
				ans = i;
				break;
			}
		}
		for (int i = ans; i >= 0; i--) {
			sb.append(arr[i]);
		}
		if (sb.length() == 0)
			return "0";
		if (nega && negb)
			return sb.toString();
		else if (nega || negb) {

			sb = new StringBuilder("-" + sb);
			return sb.toString();
		}
		return sb.toString();
	}

	static void multi(int x, String a, int arr[], int s) {
		int n = a.length();
		int k = s;
		for (int i = n - 1; i >= 0; i--) {
			int y = a.charAt(i) - '0';
			arr[k] += x * y;
			k++;
		}
	}

}
