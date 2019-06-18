package StringsAlgorithms;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {

	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1); map.put("IV", 4); map.put("V", 5); 
		map.put("IX", 9); map.put("X", 10); map.put("L", 50);
		map.put("XL", 40); map.put("C", 100); map.put("XC", 90);
		map.put("CD", 400); map.put("D", 500); map.put("I", 1);
		map.put("CM", 900); map.put("M", 1000);
		while(t > 0){
		    t--;
		    String a = s.next();
		    int ans = 0, i = 0;
		    int n = a.length();
		    while(i < n){
		        if(map.containsKey(a.substring(i, i +  2))) {
		        	ans += map.get(a.substring(i, i +  2));
		        	i += 2;
		        }
		        else {
		        	ans += map.get(a.substring(i, i + 1));
		        	i++;
		        }
		    }
		    System.out.println(ans);
		}
	}
	
}
