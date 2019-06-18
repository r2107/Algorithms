package LinkedLists;

class LengthofList {

	int lenll(Node head) {
		int c = 0;
		while(head != null) {
			head = head.next;
			c++;
		}
		return c;
	}

}
