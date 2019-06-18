package Greedy;
import java.util.*;
import java.lang.*;
import java.io.*;

public class CollectingBallsTwoRoads {
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

	public static void main(String[] args) throws IOException { 
		Reader s = new Reader(); 
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int m = s.nextInt();
		    int arr[] = new int[n];
		    int brr[] = new int[m];
		    for(int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		    }
		    for(int i = 0; i < m; i++){
		        brr[i] = s.nextInt();
		    }
		    long f = 0, sc = 0, res = 0;
		    int i = 0, j = 0;
		    while(i < n && j < m){
		        if(arr[i] < brr[j]){
		            f += arr[i++];
		        }
		        else if(arr[i] > brr[j]){
		            sc += brr[j++];
		        }
		        else{
		            res += Math.max(f, sc) + arr[i];
		            f = 0; sc = 0;
		            int temp = arr[i];
		            i++; j++;
		            while(i < n && temp == arr[i]){
		                res += arr[i++];
		            }
		            while(j < m && temp == brr[j]){
		                res += brr[j++];
		            }
		            //res += f + sc;
		        }
		    }
		    while(i < n){
		        f += arr[i++];
		    }
		    while(j < m){
		        sc += brr[j++];
		    }
		    res += Math.max(f, sc);
		    System.out.println(res);
		} 
	}
}