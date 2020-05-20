package Graphs;
import java.util.*;

public class BFSTraversal {

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
			bfs(0, graph, vis);
			System.out.println();
		}
	}

	private static void bfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		vis[src] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for(int i = 0; i < graph.get(curr).size(); i++) {
				if(!vis[graph.get(curr).get(i)]) {
					vis[graph.get(curr).get(i)] = true;
					q.add(graph.get(curr).get(i));
				}
			}
		}
		
	}
	
}
/*
Input
2
5 4
0 1 0 2 0 3 2 4
3 2
0 1 0 2
Output
0 1 2 3 4 
0 1 2 
*/