package Trees;

import java.util.HashMap;
import java.util.Scanner;

class T {
	int res;
	int dis;
}

/*
Input:
2 // no of TC 
2 // no. of edges 
1 2 L 1 3 R // tree 
4 
10 20 L 10 30 R 20 40 L 20 60 R 
Output: 
3
4
*/
public class DiameterOfBT {
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
		DiameterOfBT mt = new DiameterOfBT();
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
			diameter(root);
			t--;
		}
	}

	static void diameter(Node node) {
		System.out.println(diameter1(node).res);
		//System.out.println(diameter2(node).res);
	}

	// return the max no. nodes that can be possible between any two nodes of tree
	// including both nodes
	// 1
	// / \
	// 2 3
	// return 3 for this tree
	static T diameter1(Node node) {
		if (node == null) {
			T ans = new T();
			ans.dis = 0;
			ans.res = 0;
			return ans;
		}
		if (node.left == null && node.right == null) {
			T ans = new T();
			ans.dis = 1;
			ans.res = 0;
			return ans;
		}

		T op1 = diameter1(node.left);
		T op2 = diameter1(node.right);
		T ans = new T();
		ans.dis = Math.max(op1.dis, op2.dis) + 1;
		int x = op1.dis + op2.dis + 1;
		ans.res = Math.max(x, Math.max(op1.res, op2.res));
		return ans;
	}

	// return the max no. edges that can be possible between any two nodes of tree
	// including both nodes
	// 1
	// / \
	// 2 3
	// return 2 for this tree
	static T diameter2(Node node) {
		if (node == null) {
			T ans = new T();
			ans.dis = 0;
			ans.res = 0;
			return ans;
		}
		T op1 = diameter2(node.left);
		T op2 = diameter2(node.right);
		T ans = new T();
		ans.dis = Math.max(op1.dis, op2.dis) + 1;
		int x = op1.dis + op2.dis;
		ans.res = Math.max(x, Math.max(op1.res, op2.res));
		return ans;
	}
}
