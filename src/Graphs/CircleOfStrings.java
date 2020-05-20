package Graphs;

import java.util.*;

import javafx.scene.shape.Line;

public class CircleOfStrings {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t > 0) {
			t--;
			int n = s.nextInt();
			String arr[] = new String[n];
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for(int i = 0; i < 26; i++) {
				graph.add(new ArrayList<>());
			}
			int indegree[] = new int[26];
			for(int i = 0; i < n; i++) {
				String str = s.next();
				graph.get(str.charAt(0) - 'a').add(str.charAt(str.length() - 1) - 'a');
				indegree[str.charAt(str.length() - 1) - 'a']++;
			}
			System.out.println(isEulerianCycle(graph, indegree, 26));
			
		}

	}

	private static boolean isEulerianCycle(ArrayList<ArrayList<Integer>> graph, int indegree[], int v) {
		if(!isSC(graph, v)) return false; // strongly connected compnent 1st condition for eulierian cycle
		
		// second condition for Eucycle indeg == outdeg for each node
		for(int i = 0; i < v; i++) {
			if(graph.get(i).size() != indegree[i]) return false;
		}
		return true;
	}

	private static boolean isSC(ArrayList<ArrayList<Integer>> graph, int v) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < v; i++) {
			if(graph.get(i).size() != 0) {
				q.add(i);
				break;
			}
		}
		boolean vis[] = new boolean[26];
		while(!q.isEmpty()) {
			int curr = q.poll();
			vis[curr] = true;
			for(int i = 0; i < graph.get(curr).size(); i++) {
				if(!vis[graph.get(curr).get(i)]) {
					q.add(graph.get(curr).get(i));
				}
			}
		}
		for(int i = 0; i < 26; i++) {
			if(!vis[i] && graph.get(i).size() != 0) return false;
		}
		return true;
	}

}
