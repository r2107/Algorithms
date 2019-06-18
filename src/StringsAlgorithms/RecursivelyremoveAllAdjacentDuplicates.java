package StringsAlgorithms;
import java.util.*;
import java.lang.*;
import java.io.*;

public class RecursivelyremoveAllAdjacentDuplicates {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t > 0){
		    t--;
		    String a = s.next();
		    System.out.println(find(a, '\0'));
		}
	}
	static String find(String a, char c){
	    if(a.length() <= 1) return a;
		if(a.charAt(0) == a.charAt(1)) {
			char rem = a.charAt(0);
			int i = 1;
			while(a.charAt(i) == rem) i++;
			find(a.substring(i), rem);
		}
		String sans = find(a.substring(1), c);
		if(sans.length()!= 0 && sans.charAt(0) == a.charAt(0)) return sans.substring(1);
		if(sans.length() == 0 && c == a.charAt(0)) return "";
		return a.charAt(0) + sans;
	}
}