package Graphs;

import java.util.*;
import java.io.*;
import java.lang.*;

public class DetectCycleDirectedGraph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();
			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());
			for (int i = 1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);

			}
			if (isCyclic(list, nov) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
		// Queue q = new LinkedList<>();
		boolean vis[] = new boolean[V];
		boolean stack[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (find(list, vis, i, stack))
				return true;
		}
		return false;
	}

	static boolean find(ArrayList<ArrayList<Integer>> list, boolean vis[], int src,  boolean stack[]){
    	if(stack[src]) return true;
    	if(vis[src]) return false;
    	vis[src] = true;
    	stack[src] = true;
    	for(int i = 0; i < list.get(src).size(); i++) {
    		if(find(list, vis, list.get(src).get(i), stack)) return true;
    	}
    	stack[src] = false;
    	return false;
	}
}

/*
Input:
2
2 2 
0 1 0 0 
4 3 
0 1 1 2 2 3 
Output: 
1
0
*/
