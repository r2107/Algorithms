package Graphs;
import java.util.*;

public class TopologicalSort {

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
				//graph.get(y).add(x);
			}
			topo(graph, v);
			System.out.println();
		}
	}

	private static void topo(ArrayList<ArrayList<Integer>> graph, int v) {
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[v];
		for(int i = 0; i < v; i++) {
			if(!vis[i]) {
				topoUtil(graph, i,  s, vis);
			}
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		
	}

	private static void topoUtil(ArrayList<ArrayList<Integer>> graph, int src, Stack<Integer> s, boolean[] vis) {
		vis[src] = true;
		for(int i = 0; i < graph.get(src).size(); i++) {
			if(!vis[graph.get(src).get(i)]) {
				topoUtil(graph, graph.get(src).get(i), s, vis);
			}
		}
		s.push(src);
		
	}

}
