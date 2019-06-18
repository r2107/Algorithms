package Greedy;

import java.util.*;
class Triplet{
	int sr, d, w;
	Triplet(int a, int b, int c){sr = a; d = b; w = c;}
}
class sortby implements Comparator<Triplet>{

	@Override
	public int compare(Triplet o1, Triplet o2) {
		return o1.w - o2.w;
	}

	
}
public class KruskalsMST {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			int n = s.nextInt();//no. of vertices
			int e = s.nextInt();// no. of edges
			/*
			ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0; i < e; i++) {
				int src = s.nextInt();
				int des = s.nextInt();
				int wt = s.nextInt();
				graph.get(src).add(new Pair(des, wt));
				graph.get(des).add(new Pair(src, wt));
			}
			for(int i = 1; i < graph.size(); i++) {
				for(int j = 0; j < graph.get(i).size(); j++) {
					System.out.print(i + "->" + graph.get(i).get(j).des + "(" + graph.get(i).get(j).wt + ") .. ");
				}
				System.out.println();
			}*/
			ArrayList<Triplet> graph = new ArrayList<>();
			for(int i = 0; i < e; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				int c = s.nextInt();
				//System.out.println(a + " " + b + " " + c);
				graph.add(new Triplet(a, b, c));
			}
			Collections.sort(graph, new sortby());
			
			for(int i = 0; i < e; i++) {
				System.out.println(graph.get(i).sr + " " + graph.get(i).d + " " + graph.get(i).w);
			}
			int minweight = 0;
			int parent[] = new int[n + 1];
			//parent[graph.get(0).sr] = -1;
			//minweight += graph.get(0).w;
			for(int i = 0; i < e; i++) {
				int currs = graph.get(i).sr;
				int currd = graph.get(i).d;
				if(find(currs, currd, parent)) {
					minweight += graph.get(i).w;
					//System.out.print(minweight + " ");
					if(parent[currs] == 0 && parent[currd] == 0){
					    parent[currs] = -1;
					    parent[currd] = -1;
					}
					else{
					    parent[currd] = currs;
					    parent[currs] = currd;
					}
				}
			}
			System.out.println(minweight);
		}
		

	}
	private static boolean find(int s, int d, int parent[]) {
		if(parent[s] == -1 && parent[d] == -1) return false;
		if(parent[s] == -1 || parent[d] == -1) return true;
		if(parent[s] != 0 && parent[d] != 0) return false;
		return true;
	}

}
