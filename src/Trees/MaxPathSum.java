package Trees;

import java.util.*;
import java.lang.*;
class TreePair {
	int ans, mx;
	TreePair(int a, int b) {
		ans = a;
		mx = b;
	}
}
/*
Input:
1
12
-15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L
Output:
27
*/
public class MaxPathSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}
			System.out.println(maxPathSum(root));
		}
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}
	public static int maxPathSum(Node root) {
		return fun(root).ans;
	}
	static TreePair fun(Node root) {
		if (root == null) {
			return new TreePair(0, 0);
		}
		TreePair op1 = fun(root.left);
		TreePair op2 = fun(root.right);
		int maxpath = Math.max(0, (Math.max(op1.mx, op2.mx) + root.data));
		int sans = Math.max(0, op1.mx + op2.mx + root.data);
		int ans = Math.max(sans, Math.max(op1.ans, op2.ans));
		return new TreePair(ans, maxpath);

	}
}
