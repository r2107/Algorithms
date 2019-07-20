package BitsManipulation;
import java.util.*;
import java.lang.*;
import java.io.*;
public class LongestConsecutive1s {
	public static void main (String[] args) throws IOException{
	    //Reader s = new Reader();
	    Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    int n = s.nextInt();
		    int ans = 0;
		    while(n != 0){
		        n = n & (n << 1);
		        ans++;
		        
		    }
		    System.out.println(ans);
		    
		}
	}
}