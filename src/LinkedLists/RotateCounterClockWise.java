package LinkedLists;

public class RotateCounterClockWise {
	public Node rotate(Node head, int k) {
		// if k is > length of list
		
		// if k is neagtive
		if(k < 0) {
			System.out.println("Enter a non negative number");
			return head;
		}
		// if no need to rotate
        if(k == 0) return head;
        // rotation
        Node temp = head, curr = null, newh = null;
        int c = 0;
        while(temp != null && c < k - 1){
            temp = temp.next; c++;
        }
        if(temp != null){
            curr = temp.next;
            if(curr == null) curr = head;
            temp.next = null;
        }
        newh = curr;
        while(curr != null && curr.next != null){
            curr = curr.next;
        }
        if(curr != null && newh != head) curr.next = head;
        return newh;
    }
}
