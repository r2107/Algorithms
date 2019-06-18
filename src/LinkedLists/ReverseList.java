package LinkedLists;

public class ReverseList {
	Node reverseList(Node head){
        if(head == null || head.next == null) return head;
        Node curr = head, prev = null;
        while(curr.next != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
   }
}
