package Trees;

import java.util.HashMap;
import java.util.Scanner;
/*
Input:
2
2 // no of edges
1 2 R 1 3 L // tree
4
10 20 L 10 30 R 20 40 L 20 60 R
Output:
2 1 3
30 10 60 20 40
*/
public class MirrorOfBT {
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

	static void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		MirrorOfBT mt = new MirrorOfBT();
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}
			mirror(root);
			inOrder(root);
			System.out.println();
			t--;
		}
	}

	static void mirror(Node node) {
		Node n = fun(node);
	}

	static Node fun(Node node) {
		if (node == null)
			return null;
		Node temp = node.left;
		node.left = fun(node.right);
		node.right = fun(temp);
		return node;
	}

}
