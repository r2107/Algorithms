package Greedy;
import java.util.*;
public class LRUPageReplacement {
	// the page which is least recently used should be replaced
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0) {
			t--;
			int n = s.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			int size = s.nextInt();
			int pagefault = 0, count = 0;
			ArrayList<Integer> brr = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				if(count < size) {
					if(!brr.contains(arr[i])){
						brr.add(count, arr[i]);
						pagefault++;
						count++;
					}
					else{
					    brr.remove((Object)arr[i]);
						brr.add(arr[i]);
					}
				}
				else {
					if(!brr.contains(arr[i])){
						brr.add(arr[i]);
						brr.remove(0);
						pagefault++;
						//count++;
					}
					else {
						brr.remove((Object)arr[i]);
						brr.add(arr[i]);
					}
				}
			}
			System.out.println(pagefault);
		}

	}

}
