package FenwickTree;

import java.io.*;
import java.util.*;

//Problem Link :- https://codeforces.com/contest/1354/problem/D

//You are given a multiset consisting of n integers. You have to process queries of two types:
	// -> add integer k into the multiset;
	// -> find the k-th order statistics in the multiset and remove it.

// Output -> print any integer that belongs to the resulting multiset. else 0
/*
5 4
1 2 3 4 5
-5 -1 -3 -1
*/

/*
3
*/

public class kthSmallestInMultisetUpdateAndQuery {
	
	static final long mod = 1000000007;
	static final long lmx = 9223372036854775807l, lmn = -9223372036854775808l;
	static final int imx = 2147483647, imn = -2147483648;
	static final String Y = "YES", NO = "NO", LN = "\n", SPC = " ";
	//static Scanner s = new Scanner(System.in);
	static Reader s = new Reader();
	static PrintWriter out = new PrintWriter(System.out);
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		int t = 1;
		//update(new int[50], 21, 50);
		//query(new int[50], 15, 50);
		//t = s.nextInt();
		//slinp();
		while (t > 0) {
			t--;
			int n = iinp(), q = iinp();
			int a[] = new int[n + 1];
			int tree[] = new int[n + 1];
			for(int i = 1; i <= n; i++) {
				int x = iinp();
				update(tree, x, 1, n);
				a[x]++;
			}
			//for(int i = 1; i <= n; i++) System.out.println(tree[i]);
			while(q-- > 0) {
				int k = iinp();
				if(k < 0) {
					k = 0 - k;
					int low = 1, end = n, ans = 0;
					while(low <= end) {
						int mid = (low + end) / 2;
						int sans = query(tree, mid);
						if(sans < k) {
							low = mid + 1;
						}
						else {
							ans = mid;
							end = mid - 1;
						}
					}
					//System.out.println(ans);
					update(tree, ans, -1, n);
					a[ans]--;
				}
				else {
					a[k]++;
					update(tree, k, 1, n);
				}
			}
			int res = 0;
			for(int i = 1; i <= n; i++) 
				if(a[i] > 0) {
					res = i; break;
				}
			sb.append(res);
			ln();
		}
		out.print(sb);
		out.flush();
	}

	
	
	private static void update(int[] tree, int x, int val, int n) {
		
		for(int i = x; i <= n; i += i & (-i)) {
			tree[i] += val;
			//System.out.println(i);
		}
		
	}
	
	private static int query(int[] tree, int x) {
		int ans = 0;
		for(int i = x; i > 0; i -= i & (-i)) {
			ans += tree[i];
		}
		return ans;
	}



	static void app(String x) throws IOException {
		sb.append(x);
	}

	static void spc() throws IOException {
		sb.append(SPC);
	}

	static void ln() throws IOException {
		sb.append(LN);
	}

	static int iinp() throws IOException {
		return s.nextInt();
	}

	static long linp() throws IOException {
		return s.nextLong();
	}

	static double dinp() throws IOException {
		return s.nextDouble();
	}

	static String sinp() throws IOException {
		return s.next();
	}

	static String slinp() throws IOException {
		return s.nextLine();
	}

	static int[] iarr(int n) {
		return new int[n];
	}

	static long[] larr(int n) {
		return new long[n];
	}

	static double[] darr(int n) {
		return new double[n];
	}

	static boolean[] barr(int n) {
		return new boolean[n];
	}

	static String[] sarr(int n) {
		return new String[n];
	}

	static int[][] iarr(int n, int m) {
		return new int[n][m];
	}

	static long[][] larr(int n, int m) {
		return new long[n][m];
	}

	static int[] iinp(int n, int st, int size) throws IOException {
		int a[] = iarr(n);
		for (int i = st; i < st + size; i++)
			a[i] = iinp();
		return a;
	}

	static long[] linp(int n, int st, int size) throws IOException {
		long a[] = larr(n);
		for (int i = st; i < st + size; i++)
			a[i] = linp();
		return a;
	}

	static String[] sinp(int n, int st, int size, String str) throws IOException {
		String a[] = sarr(n);
		for (int i = st; i < st + size; i++)
			if (str.equalsIgnoreCase(SPC))
				a[i] = sinp();
			else
				a[i] = slinp();
		return a;
	}

	static int[][] iinp(int n, int m, int row, int rows, int col, int cols) throws IOException {
		int a[][] = iarr(n, m);
		for (int i = row; i < row + rows; i++)
			for (int j = col; j < col + cols; j++)
				a[i][j] = iinp();
		return a;
	}

	static long[][] linp(int n, int m, int row, int rows, int col, int cols) throws IOException {
		long a[][] = larr(n, m);
		for (int i = row; i < row + rows; i++)
			for (int j = col; j < col + cols; j++)
				a[i][j] = linp();
		return a;
	}

	static void ginp(ArrayList<Integer> g[], int m) throws IOException {
		for (int i = 0; i < m; i++) {
			int u = iinp(), v = iinp();
			g[u].add(u);
			g[v].add(u);
		}
	}

	static long min(long... a) {
		long min = lmx;//Long.MAX_VALUE;
		for (long i : a)
			if (i < min)
				min = i;
		return min;
	}

	static int min(int... a) {
		int min = imx;//Long.MAX_VALUE;
		for (int i : a)
			if (i < min)
				min = i;
		return min;
	}

	static long max(long... a) {
		long max = lmn;//Long.MIN_VALUE;
		for (long i : a)
			if (i > max)
				max = i;
		return max;
	}

	static int max(int... a) {
		int max = imn;//Long.MIN_VALUE;
		for (int i : a)
			if (i > max)
				max = i;
		return max;
	}
	
	// for Fast IO in Java
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String nextLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public String next() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == ' ')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}


}
