package LinkedLists;

public class PalindromeList {
	int lenll(Node head) {
		int c = 0;
		while(head != null) {
			head = head.next;
			c++;
		}
		return c;
	}
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) {
        int l = lenll(head);
        if(l < 2) return true;
        Node curr = head, prev = null;
        int c = 0;
        while(c < (l + 1) / 2){
            Node t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
            c++;
        }
        Node last;
        if(l % 2 == 0) last = prev;
        else last = prev.next;
        Node ne = curr;
        while(last != null && curr != null && last.data == curr.data){
            last = last.next;
            curr = curr.next;
        }
        if(last == null || curr == null) return true;
        return false;
    }    
}
