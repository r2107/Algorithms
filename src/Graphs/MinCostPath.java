package Graphs;
import java.util.*;
import java.lang.*;
import java.io.*;

class Nod implements Comparator<Nod>{
	int v, d;
	Nod(int a, int b){v = a; d = b;}
	Nod(){}
	@Override
	public int compare(Nod a0, Nod a1) {
		return a0.d - a1.d;
	}
}
public class MinCostPath {
	static int y[] = { 1, 0, -1, 0 };
	static int x[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// Reader s = new Reader();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			// boolean b[][] = new boolean[n][m];
			ArrayList<ArrayList<Nod>> graph = new ArrayList<>();
			for (int i = 0; i < n * n; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int on = ((i * n) + j);
					for (int k = 0; k < 4; k++) {
						int nx = i + x[k];
						int ny = j + y[k];
						if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
							int nn = ((nx * n) + ny);
							graph.get(on).add(new Nod(nn, arr[nx][ny]));
						}
					}
				}
			}
			/*
			 * for (int i = 0; i < n * m; i++) { for (int j = 0; j < graph.get(i).size();
			 * j++) { System.out.print(graph.get(i).get(j) + " "); } System.out.println(); }
			 */
			//int des = (((n - 1) * n) + (n - 1));
			System.out.println(dijkstra(graph, 0, n * n) + arr[0][0]);

		}
	}

	static int dijkstra(ArrayList<ArrayList<Nod>> list, int src, int V){
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		boolean vis[] = new boolean[V];
		// first solution
		for(int i = 0; i < V; i++) {
			int m = findmin(dist, vis);
			if(m == -1) continue;
			vis[m] = true;
			for(int j = 0; j < list.get(m).size(); j++) {
				int dis = dist[m] + list.get(m).get(j).d;
				if(!vis[list.get(m).get(j).v] && dis < dist[list.get(m).get(j).v] && list.get(m).get(j).d != 0) {
					dist[list.get(m).get(j).v] = dis;
				}
			}
		}
		
		/*for(int i = 0; i < V; i++) {
			System.out.print(dist[i] + " ");
		}*/
		return dist[V - 1];
		
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