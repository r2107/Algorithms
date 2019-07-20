package Trees;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;
/*
Input
1
5
1 2 L 1 3 R 2 4 R 4 5 R 5 6 R
Output
2 1 4 5 3 6
*/
public class VerticalTraversalofBT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n-- > 0) {
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
			}
			// if multinodes on same vertcal line
			// this will print the first node coming first in level wise means more near to root 
			// will be printed first
			verticalOrder(root);//2 1 4 3 5 6 output
			// now this will print multinodes in same vertical line in preorder traversal
			verticalOrder1(root); //2 1 4 5 3 6
			System.out.println();
		}
	}

	private static void verticalOrder1(Node root) {
		TreeMap<Integer, ArrayList<Node>> map = new TreeMap();
		fun(root, 0, map);
		//Set<Entry<Integer, ArrayList<Node>>> itr = map.entrySet();
		for (Entry<Integer, ArrayList<Node>> entry : map.entrySet()) { 
            ArrayList<Node> ans = entry.getValue();
            for(int i = 0; i < ans.size(); i++) {
            	System.out.print(ans.get(i).data + " ");
            }
        }
		
	}

	private static void fun(Node root, int h, TreeMap<Integer, ArrayList<Node>> map) {
		if(root == null) return;
		if(map.containsKey(h)) {
			ArrayList<Node> ans = map.get(h);
			ans.add(root);
			map.put(h, ans);
		}
		else {
			ArrayList<Node> ans = new ArrayList<>();
			ans.add(root);
			map.put(h, ans);
		}
		fun(root.left, h - 1, map);
		fun(root.right, h + 1, map);
		
	}

	static void verticalOrder(Node root) {
		if (root == null)
			return;
		HashMap<Integer, ArrayList<Node>> map = new HashMap();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));
		ArrayList<Node> l1 = new ArrayList<>();
		l1.add(root);
		int min = 0, max = 0;
		map.put(0, l1);
		while (!q.isEmpty()) {
			Pair c = q.poll();
			Node cur = c.n;
			int lvl = c.l;
			if (lvl < min)
				min = lvl;
			if (lvl > max)
				max = lvl;
			if (cur.left != null) {
				q.add(new Pair(cur.left, lvl - 1));
				ArrayList<Node> l = new ArrayList<>();
				if (map.containsKey(lvl - 1)) {
					l = map.get(lvl - 1);
					l.add(cur.left);
					map.put(lvl - 1, l);
				} else {
					l.add(cur.left);
					map.put(lvl - 1, l);
				}
			}
			if (cur.right != null) {
				q.add(new Pair(cur.right, lvl + 1));
				ArrayList<Node> l = new ArrayList<>();
				if (map.containsKey(lvl + 1)) {
					l = map.get(lvl + 1);
					l.add(cur.right);
					map.put(lvl + 1, l);
				} else {
					l.add(cur.right);
					map.put(lvl + 1, l);
				}
			}
		}
		for (int i = min; i <= max; i++) {
			if (map.containsKey(i)) {
				ArrayList<Node> ans = map.get(i);
				for (int j = 0; j < ans.size(); j++) {
					System.out.print(ans.get(j).data + " ");
				}
			}
		}

	}
}
