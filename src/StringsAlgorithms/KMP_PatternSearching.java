/*
 * This is an implementation class for Knuth Morris Pratt pattern searching
 * @author Rahul Lather
 */
package StringsAlgorithms;
import java.util.Scanner;
public class KMP_PatternSearching {
	// Knuth Morris Pratt Pattern Seaching
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String text = s.nextLine();
		String pattern = s.nextLine(); // pattern to search in the text string
		System.out.println(findString(text, pattern));
	}
	/*
	 * @param pattern stores the pattern to be searched
	 *  Compute Longest Prefix Suffix values
	 */
    static void findLPS(String pattern, int lps[]){
        int n = pattern.length();
        int j = 0, i = 1;
        lps[0] = 0;
        while(i < n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j + 1;
                i++; j++;
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                	lps[i] = 0;
                    i++;
                }
            }
        }
    }
	public static int findString(String text, String pattern) {
		int n = text.length();
        int m = pattern.length();
        int lps[] = new int[m];
        findLPS(pattern, lps);
        int i = 0, j = 0;
        while(i < n && j < m){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;j++;
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }
        if(j == m){
            return i - j;
        }
        return -1;
	}
}

