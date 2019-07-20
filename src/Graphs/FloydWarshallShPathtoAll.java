package Graphs;
import java.util.*;
import java.lang.*;
import java.io.*;
public class FloydWarshallShPathtoAll {
    	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int arr[][] = new int[n][n];
		    int dist[][] = new int[n][n];
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            arr[i][j] = s.nextInt();
		            dist[i][j] = arr[i][j];
		        }
		    }
		    for(int k = 0; k < n; k++){
		        for(int i = 0; i < n; i++){
		            for(int j = 0; j < n; j++){
		                int dis = dist[i][k] + dist[k][j];
		                if(dis < 0) dis = dist[i][j];
		                else dist[i][j] = Math.min(dis, dist[i][j]);
		            }
		        }
		    }
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            if(dist[i][j] == 10000000) System.out.print("INF ");
		            else System.out.print(dist[i][j] + " ");
		        }
		        System.out.println();
		    }
		    
		}
	}
}