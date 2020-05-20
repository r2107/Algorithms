package Graphs;
import java.util.*;
/*class Nod {
	int v, d;

	Nod(int a, int b) {
		v = a;
		d = b;
	}
}*/

public class SnakeLadderProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int n = s.nextInt();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= 30; i++) {
				graph.add(new ArrayList<Integer>());
			}
			int map[] = new int[31];
			for(int i = 0; i < 31; i++) {
				map[i] = i;
			}
			for (int i = 0; i < n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				map[a] = b;
			}
			for (int i = 1; i < 30; i++) {
				int k = 1;
				while (k <= 6 && i + k <= 30) {
					graph.get(i).add(map[i + k]);
					k++;
				}

			}
			/*for (int i = 0; i <= 30; i++) {
				for (int j = 0; j < graph.get(i).size(); j++) {
					System.out.print(graph.get(i).get(j) + " ");
				}
				System.out.println();
			}*/
			System.out.println(find(graph, 1, 30));

		}

	}

	private static int find(ArrayList<ArrayList<Integer>> graph, int src, int des) {
		boolean vis[] = new boolean[31];
		Queue<Nod> q = new LinkedList<>();
		q.add(new Nod(src, 0));
		int dis = 0;
		while (!q.isEmpty()) {
			Nod c = q.poll();
			dis = c.d;
			int cur = c.v;
			if (cur == des)
				break;
			vis[cur] = true;
			for (int i = 0; i < graph.get(cur).size(); i++) {
				if (!vis[graph.get(cur).get(i)]) {
					q.add(new Nod(graph.get(cur).get(i), dis + 1));
				}
			}

		}

		return dis;
	}

}
