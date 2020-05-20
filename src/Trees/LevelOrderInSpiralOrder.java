package Trees;

import java.util.*;
import java.lang.*;
import java.io.*;
/*
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
Output:
1 3 2
10 20 30 60 40
*/
public class LevelOrderInSpiralOrder {
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
			printSpiral(root);
			System.out.println();
			t--;
		}
	}

	static void printSpiral(Node node) {
		if(node == null) return;
		Stack<Node> ltr = new Stack<>();
		Stack<Node> rtl = new Stack<>();
		System.out.print(node.data + " ");
		if(node.right != null) {
			ltr.push(node.right);
		}
		if(node.left != null) {
			ltr.push(node.left);
		}
		while(!ltr.isEmpty() || !rtl.isEmpty()) {
			while(!ltr.isEmpty()) {
				Node c = ltr.pop();
				System.out.print(c.data + " ");
				if(c.left != null) {
					rtl.push(c.left);
				}
				if(c.right != null) {
					rtl.push(c.right);
				}			
			}
			while(!rtl.isEmpty()) {
				Node c = rtl.pop();
				System.out.print(c.data + " ");
				if(c.right != null) {
					ltr.push(c.right);
				}
				if(c.left != null) {
					ltr.push(c.left);
				}				
			}
			
		}
		
		
	}
}
