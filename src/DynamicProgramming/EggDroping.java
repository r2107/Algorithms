package DynamicProgramming;

import java.util.*;

public class EggDroping {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int eg = s.nextInt();
			int f = s.nextInt();
			int dp[][] = new int[eg + 1][f + 1];
			for (int i = 0; i <= f; i++) {
				dp[1][i] = i;
			}
			for (int i = 2; i <= eg; i++) {
				for (int j = 1; j <= f; j++) {
					int min = Integer.MAX_VALUE;
					for (int m = 1; m <= j; m++) {
						int op1 = dp[i - 1][m - 1];
						int op2 = dp[i][j - m];
						int sans = Math.max(op1, op2) + 1;
						if (min > sans)
							min = sans;
					}
					dp[i][j] = min;
				}
			}
			System.out.println(dp[eg][f]);
		}

	}

}
