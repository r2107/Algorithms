package DynamicProgramming;

import java.util.*;
import java.lang.*;
import java.io.*;
public class Knapsack01 {
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

		public String readLine() throws IOException { 
			byte[] buf = new byte[64]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) 
			{ 
				if (c == '\n') 
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
			do
			{ 
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
			} 
			while ((c = read()) >= '0' && c <= '9'); 
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
			} 
			while ((c = read()) >= '0' && c <= '9'); 

			if (c == '.') 
			{ 
				while ((c = read()) >= '0' && c <= '9') 
				{ 
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
	public static void main (String[] args) throws IOException{
		Reader s = new Reader();
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int w = s.nextInt();
		    int val[] = new int[n];
		    int wt[] = new int[n];
		    for(int i = 0; i < n; i++){
		        val[i] = s.nextInt();
		    }
		    for(int i = 0; i < n; i++){
		        wt[i] = s.nextInt();
		    }
		    // memoized solution
		    /*int dp[][] = new int[n][w + 1];
		    for(int i = 0; i < n; i++){
		        Arrays.fill(dp[i], -1);
		    }
		    System.out.println(find(val, wt, 0, w, n, dp));*/
		    
		    // dp iterative
		    int dp[][] = new int[2][w+1];
		    for(int i = 0; i <= w; i++){
		        if(wt[0] <= i) dp[0][i] = val[0];
		        else dp[0][i] = 0;
		    }
		    int curr = 1;
		    for(int i = 1; i < n; i++){
		        for(int j = 0; j <= w; j++){
		            int op1 = -1;
		            if(wt[i] <= j){
		                op1 = dp[curr^1][j - wt[i]] + val[i];
		            }
		            dp[curr][j] = Math.max(op1, dp[curr^1][j]);
		        }
		        curr ^= 1;
		    }
		    System.out.println(dp[curr^1][w]);
		}
	}
	static int find(int val[], int wt[], int s, int w, int n, int dp[][]){
	    if(w < 0){
	        return 0;
	    }
	    if(s == n - 1){
	        if(wt[s] <= w){
	            return val[s];
	        }
	        return 0;
	    }
	    if(dp[s][w] != -1) return dp[s][w];
	    int op1 = 0;
	    if(w >= wt[s])
	        op1 = find(val, wt, s + 1, w - wt[s], n, dp) + val[s];
	    int op2 = find(val, wt, s + 1, w, n, dp);
	    return dp[s][w] = Math.max(op1, op2);
	}
	
}




