package Trees;

import java.util.Scanner;

public class LowestCommanAncestor {
	Node root;
	void insert(Node root, int key) {
		if (key < root.data) {
			if (root.left != null)
				insert(root.left, key);
			else {
				root.left = new Node(key);
			}
		} else if (key > root.data) {
			if (root.right != null)
				insert(root.right, key);
			else {
				root.right = new Node(key);
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			LowestCommanAncestor tree = new LowestCommanAncestor();
			int a1 = sc.nextInt();
			Node root = new Node(a1);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				tree.insert(root, a);
			}
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node s = LCA(root, n1, n2);
			System.out.println(s.data);

			t--;
		}
	}

	static Node LCA(Node node, int n1, int n2) {
		if (node.data == n1 || node.data == n2)
			return node;
		if (node.data < n1 && node.data < n2) {
			return LCA(node.right, n1, n2);
		} else if (node.data > n1 && node.data > n2) {
			return LCA(node.left, n1, n2);
		} else {
			return node;
		}

	}
}
/*
Input
2
6
5 4 6 3 7 8
7 8
6
12 14 15 10 9 8
8 15

Output 
7
12
*/