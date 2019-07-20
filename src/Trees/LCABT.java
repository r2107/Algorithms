package Trees;
import java.util.*;
import java.lang.*;
import java.io.*;

public class LCABT {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
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

			int a = sc.nextInt();
			int b = sc.nextInt();

			Node k = lca(root, a, b);
			if(k != null) System.out.println(k.data);
			else System.out.println("Not Exist");
			t--;

		}
	}
	static boolean v1, v2;
	static Node findLCAUtil(Node node, int n1, int n2) {
		if (node == null)
			return null;
		// Store result in temp, in case of key match so that we can search for other
		// key also.
		Node temp = null;
		if (node.data == n1) {
			v1 = true;
			temp = node;
		}
		if (node.data == n2) {
			v2 = true;
			temp = node;
		}
		Node left_lca = findLCAUtil(node.left, n1, n2);
		Node right_lca = findLCAUtil(node.right, n1, n2);
		if (temp != null)
			return temp;
		if (left_lca != null && right_lca != null)
			return node;
		return (left_lca != null) ? left_lca : right_lca;
	}

	static Node lca(Node root, int n1, int n2) {
		v1 = false;
		v2 = false;
		Node lc = findLCAUtil(root, n1, n2);
		if (v1 && v2)
			return lc;
		return null;
	}
}
