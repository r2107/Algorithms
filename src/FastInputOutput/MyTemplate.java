package FastInputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTemplate {
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(s.readLine());
		StringBuilder sb = new StringBuilder();
		while(t > 0){
		    t--;
		    int n = Integer.parseInt(s.readLine());
		    int arr[] = new int[n];
		    String line = s.readLine();
		    String str[] = line.trim().split("\\s+");
		    for(int i = 0; i < n; i++) {
		    	arr[i] = Integer.parseInt(str[i]);
		    }
		    // your code goes here
		    
		}
		System.out.println(sb);
	}
}
