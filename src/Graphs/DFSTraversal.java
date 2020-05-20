package Graphs;

import java.util.*;

public class DFSTraversal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			int v = s.nextInt();
			int e = s.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i = 0; i < v; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for(int i = 0; i < e; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			boolean vis[] = new boolean[v];
			dfs(0, graph, vis);
		}
	}
	
	static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
		System.out.print(src + " ");
		vis[src] = true;
		for (int i = 0; i < list.get(src).size(); i++) {
			if (!vis[list.get(src).get(i)]) {
				dfs(list.get(src).get(i), list, vis);
			}
		}
	}

}
/*
Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3    // dfs from node 0
0 1 2 3
*/