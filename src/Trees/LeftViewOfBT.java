package Trees;

import java.io.*;
import java.util.*;
class Pair {
	Node n;
	int l;
	Pair(Node a, int b) {
		n = a;
		l = b;
	}
}
/*
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
Output:
1 3
10 20 40
*/
public class LeftViewOfBT {
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
			leftView(root);
			System.out.println();
			t--;
		}
	}
	static void leftView(Node root) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair c = q.poll();
			if (!map.containsKey(c.l)) {
				map.put(c.l, false);
				System.out.print(c.n.data + " ");
			}
			if (c.n.left != null) {
				q.add(new Pair(c.n.left, c.l + 1));
			}
			if (c.n.right != null) {
				q.add(new Pair(c.n.right, c.l + 1));
			}

		}
	}
}
