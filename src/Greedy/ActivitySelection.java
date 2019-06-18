package Greedy;
import java.util.*;
import java.io.*;
class P{
    long s, e;
    P(long l, long m){s = l; e = m;}
}
class sort implements Comparator<P>{
    public int compare(P a, P b){
        return (int) (a.e - b.e);
    }
}
public class ActivitySelection {
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        P arr[] = new P[n];
        for(int i = 0; i < n; i++){
        	long x = s.nextLong();
        	long y = s.nextLong();
            arr[i] = new P(x, y);
        }
        Arrays.sort(arr, new sort());
        int ans = 1;
        long finish = arr[0].e;
        for(int i = 1; i < n; i++){
            if(arr[i].s >= finish){
                ans++;
                finish = arr[i].e;
            }
        }
        System.out.println(ans);
	}

}