package LinkedLists;
import java.util.*;
import java.lang.*;
public class ReverseInGroups{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            int k = sc.nextInt();
            GfG gfg = new GfG();
            Node res = gfg.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}
class GfG{   
    static Node reverseList(Node head){
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
    // iterative approach
    public static Node reverse(Node node, int k){
        if(node == null || node.next == null || k <= 1) return node;
        Node curr = node, prev = node, link = node, t1 = null, t = null;
        
        while(curr != null){
            int c = 0;
            while(curr != null && c < k - 1){
                curr = curr.next; c++;
            }
            Node temp;
            if(curr == null) temp = null;
            else {
            	temp = curr.next;
            	curr.next = null;
            }
            t = reverseList(prev);
            if(t1 != null)
                t1.next = t;
            else node = t;
            t1 = t;
            while(t1.next != null) t1 = t1.next;
            curr = temp;
            prev = curr;
        }
        return node;
    }
}
