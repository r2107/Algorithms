package Trees;

import java.util.*;

class NodePair {
	Node f, l;

	NodePair(Node a, Node b) {
		f = a;
		l = b;
	}
}

public class BTtoDoublyLL {
	void inorder(Node node) {
		if (node == null)
			return;
		else
			inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	void printList(Node head) {
		Node prev = head;
		while (head != null) {
			System.out.print(head.data + " ");
			prev = head;
			head = head.right;
		}

		System.out.println();
		while (prev != null) {
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BTtoDoublyLL obj = new BTtoDoublyLL();
		int t = sc.nextInt();
		while (t > 0) {
			HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
			int n = sc.nextInt();

			Node root = null;

			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				Node parent = hm.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					hm.put(n1, parent);
					if (root == null) {
						root = parent;
						// d.head = root;
					}

				}

				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;

				hm.put(n2, child);
				n--;
			}

			GfG g = new GfG();
			Node node = g.bToDLL(root);
			obj.printList(node);
			t--;
			System.out.println();
		}
	}
}

class GfG {
	Node head;

	// This function should convert a given Binary tree to Doubly
	// Linked List
	Node bToDLL(Node root) {
		return fun(root).f;
	}

	NodePair fun(Node root) {
		if (root == null) {
			return null;
		}
		NodePair sans = fun(root.left);
		if (sans == null) {
			Node n = new Node(root.data);
			sans = new NodePair(n, n);
		} else {
			Node n = new Node(root.data);
			n.left = sans.l;
			sans.l.right = n;
			sans.l = n;
		}

		NodePair op = fun(root.right);
		if (op == null) {
			return sans;
		}
		sans.l.right = op.f;
		op.f.left = sans.l;
		sans.l = op.l;
		return sans;
	}

}
/*
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output: // both traversals of DLL
3 1 2 
2 1 3 
40 20 60 10 30 
30 10 60 20 40
*/