package Trees;

import java.util.*;

class Tree {
	int data;
	Tree left, right;

	Tree(int d) {
		data = d;
		left = right = null;
	}
}

public class SerializeDeserializeBT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Tree root = null;
			if (n == 1) {
				System.out.println(sc.nextInt());
				n--;
			}
			while (n-- > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (root == null) {
					root = new Tree(n1);
					switch (lr) {
					case 'L':
						root.left = new Tree(n2);
						break;
					case 'R':
						root.right = new Tree(n2);
						break;
					}
				} else {
					insert(n1, n2, lr, root);
				}
			}
			ArrayList<Integer> aa = new ArrayList<Integer>();
			Solution g = new Solution();
			String s = g.serialize(root, aa);
			Tree root1 = g.deSerialize(s);
			inorder(root1);
			System.out.println();
		}
	}

	public static void inorder(Tree root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void insert(int n1, int n2, char lr, Tree root) {
		if (root == null) {
			return;
		}
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new Tree(n2);
				break;
			case 'R':
				root.right = new Tree(n2);
				break;
			}
		}
		insert(n1, n2, lr, root.left);
		insert(n1, n2, lr, root.right);
	}
}
class Solution{
    int j = 0;
	public String serialize(Tree root, ArrayList<Integer> aa) {
	    fun(root, aa);
	    String ans = "";
	    for(int i = 0; i < aa.size(); i++){
	        ans = ans + "" + aa.get(i) + " ";
	    }
	    //System.out.println(ans);
	    return ans;
    }
    void fun(Tree root, ArrayList<Integer> aa){
        if(root == null){
            aa.add(-1);
            return;
        }
        aa.add(root.data);
        fun(root.left, aa);
        fun(root.right, aa);
    }
    public Tree deSerialize(String data) {
        Tree root = fun2(data);
        return root;
    }   
    public Tree fun2(String data){
        String s = "";
        while(j < data.length() && data.charAt(j) != ' '){
            s = s + data.charAt(j);
            j++;
        }
        j++;
        //System.out.println(s);
        int x = Integer.parseInt(s);
        if(x == -1){
            Tree root = null;
            return root;
        }
        Tree root = new Tree(x);
        root.left = fun2(data);
        root.right = fun2(data);
        return root;
    } 
    
}