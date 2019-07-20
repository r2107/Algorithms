package Graphs;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestSourceToDestinationPath {
	static int y[] = { 1, 0, -1, 0 };
	static int x[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// Reader s = new Reader();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			int m = s.nextInt();
			int arr[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			//boolean b[][] = new boolean[n][m];
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < n * m; i++) {
				graph.add(new ArrayList<>());
			}
			int xd = s.nextInt();
			int yd = s.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					//b[i][j] = true;
					int on = ((i * m) + j);
					for (int k = 0; k < 4; k++) {
						if (arr[i][j] == 1) {
							int nx = i + x[k];
							int ny = j + y[k];
							if (nx >= 0 && nx < n && ny >= 0 && ny < m) {// && !b[nx][ny]
								int nn = ((nx * m) + ny);
								if (arr[nx][ny] == 1)
									graph.get(on).add(nn);
								// else if(nx == xd && ny == yd)
								// graph.get(on).add(nn);
							}
						}
					}
				}
			}
			/*for (int i = 0; i < n * m; i++) {
				for (int j = 0; j < graph.get(i).size(); j++) {
					System.out.print(graph.get(i).get(j) + " ");
				}
				System.out.println();
			}*/
			int des = ((xd * m) + yd);
			if(0 == des && arr[xd][yd] == 0)
			    System.out.println(-1);
			else
			    System.out.println(find(graph, 0, des, n * m));

		}
	}

	private static int find(ArrayList<ArrayList<Integer>> graph, int src, int des, int size) {
		boolean vis[] = new boolean[size];
		Queue<Nod> q = new LinkedList<>();
		q.add(new Nod(src, 0));
		int dis = 0;
		vis[src] = true;
		while (!q.isEmpty()) {
			Nod c = q.poll();
			dis = c.d;
			int cur = c.v;
			if (cur == des)
				return dis;
			for (int i = 0; i < graph.get(cur).size(); i++) {
				if (!vis[graph.get(cur).get(i)]) {
					vis[graph.get(cur).get(i)] = true;
					q.add(new Nod(graph.get(cur).get(i), dis + 1));
				}
			}

		}

		return -1;
	}
}
/*
Input:
2
3 4
1 0 0 0 1 1 0 1 0 1 1 1
2 3
3 4
1 1 1 1 0 0 0 1 0 0 0 1
0 3
Output:
5
3
*/