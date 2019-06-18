package StringsAlgorithms;

public class StringToInteger {

	public static void main(String[] args) {
		String a = "12134";
		String b = "121sbs34";
		String c = "-9934";
		System.out.println(strtoint(a));
		System.out.println(strtoint(b));
		System.out.println(strtoint(c));
	}
	static int fun(char x){
        return x - 48;
    }
    static int strtoint(String str) {
	    int n = str.length();
	    int i = n - 1;
	    int ans = 0;
	    while(i >= 0){
	        if(i == 0 && str.charAt(i) == '-') return 0 - ans;
	        int x = fun(str.charAt(i));
	        if(x > 9 || x < 0) return -1;
	        ans += Math.pow(10, n - i - 1) * x;
	        i--;
	    }
	    return (ans);
    }
	
}
