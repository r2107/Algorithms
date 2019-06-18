package LinkedLists;

public class LLUse {

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		a.next = b;
		//length of ll
		LengthofList l = new LengthofList();
		System.out.println(l.lenll(a));

	}

}
