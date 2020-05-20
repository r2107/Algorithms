package Graphs;

import java.util.*;
class Node implements Comparator<Node>{
	int v, d;
	Node(int a, int b){v = a; d = b;}
	Node(){}
	@Override
	public int compare(Node a0, Node a1) {
		return a0.d - a1.d;
	}
}
public class DijkstraImplementation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int V = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
            for(int i = 0;i < V; i++){
                ArrayList<Integer> temp = new ArrayList<>(V);
                list.add(i, temp);
            }
            for(int i = 0; i < V; i++) {
                ArrayList<Integer> temp = list.get(i);
                for(int j = 0; j < V; j++) {
                    temp.add(sc.nextInt());
                }
                list.add(temp);
            }
            int s = sc.nextInt(); //src vertex
            dijkstra(list, s, V);
            System.out.println();
            
        }
	}
	static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V){
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		boolean vis[] = new boolean[V];
		/* first solution
		for(int i = 0; i < V; i++) {
			int m = findmin(dist, vis);
			if(m == -1) continue;
			vis[m] = true;
			for(int j = 0; j < list.get(m).size(); j++) {
				int dis = dist[m] + list.get(m).get(j);
				if(!vis[j] && dis < dist[j] && list.get(m).get(j) != 0) {
					dist[j] = dis;
				}
			}
		}
		
		for(int i = 0; i < V; i++) {
			System.out.print(dist[i] + " ");
		}*/
		// second sol using priority queue
		PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
		Node n = new Node(src, 0);
		pq.add(n);
		for(int i = 0; i < V; i++) {
			//int m = findmin(dist, vis);
			int m = pq.remove().v;
			vis[m] = true;
			for(int j = 0; j < list.get(m).size(); j++) {
				int dis = dist[m] + list.get(m).get(j);
				if(!vis[j]) {
					if(dis < dist[j]) {
						dist[j] = dis;
					}
					pq.add(new Node(j, dist[j]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < V; i++) {
			sb.append(dist[i] + " ");
		}
		
    }
	private static int findmin(int[] dist, boolean[] vis) {
		int min = -1, m = Integer.MAX_VALUE;
		for(int i = 0; i < vis.length; i++) {
			if(!vis[i] && (dist[i] < m)){
			    m = dist[i];
			    min = i;
			}
		}
		return min;
	}
	

}






