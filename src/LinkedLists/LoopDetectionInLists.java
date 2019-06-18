package LinkedLists;

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks {
	public static Node newNode(int data) {
		Node temp = new Node(data);
		//temp.data = data;
		temp.next = null;
		return temp;
	}

	public static Node insert(Node head, int data) {
		if (head == null)
			head = newNode(data);
		else
			head.next = insert(head.next, data);
		return head;
	}

	public static void makeLoop(Node head, int x) {
		if (x == 0)
			return;
		Node curr = head;
		Node last = head;
		int counter = 0;
		while (counter < x) {
			curr = curr.next;
			counter++;
		}
		while (last.next != null)
			last = last.next;
		last.next = curr;
	}

	public static int detectloop(Node head) {
		Node hare = head.next;
		Node tortoise = head;
		while (hare != tortoise && hare != null && tortoise != null) {
			hare = hare.next;
			tortoise = tortoise.next;
			if (hare != null && hare.next != null)
				hare = hare.next;
			if (hare == tortoise)
				return 1;
		}
		if (hare == tortoise)
			return 1;
		return 0;
	}

	public static int length(Node head, boolean hasloop) {
		int len = 0;
		if (hasloop == false) {
			Node temp = head;
			while (temp != null) {
				len++;
				temp = temp.next;
			}
			return len;
		}
		else {
			Node hare = head.next;
			Node tortoise = head;
			while (hare != tortoise) {
				hare = hare.next;
				tortoise = tortoise.next;
				hare = hare.next;
				if (hare == tortoise)
					break;
			}

			int looplen = 0;
			while (hare.next != tortoise) {
				hare = hare.next;
				looplen++;
			}

			looplen++;
			Node begin = head;
			int startlen = 0;
			tortoise = tortoise.next;
			while (begin != tortoise) {

				begin = begin.next;
				tortoise = tortoise.next;
				startlen++;
			}
			return looplen + startlen;

		}
	}
}

public class LoopDetectionInLists {
	public static void main(String[] args) {
		/* code */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int sizeOfArray = sc.nextInt();
			int arr[] = new int[sizeOfArray];

			for (int i = 0; i < sizeOfArray; i++)
				arr[i] = sc.nextInt();

			Node head = null;

			for (int i = 0; i < sizeOfArray; i++) {
				head = new Geeks().insert(head, arr[i]);
			}
			int x = sc.nextInt();
			new Geeks().makeLoop(head, x);

			int length = 0;
			if (new Geeks().detectloop(head) == 1) {
				length = new Geeks().length(head, true);
			} else {
				length = new Geeks().length(head, false);
			}
			new Loop().removeTheLoop(head);
			if (new Geeks().detectloop(head) == 0 && length == new Geeks().length(head, false))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}

class Loop {

	// This function will remove the loop from the linked list
	public static void removeTheLoop(Node head) {
		// This is known as Floyd’s Cycle-Finding Algorithm
		// The slow and fast pointer both meet at the same point which is the last point
		// of cycle
		// 1->2->3->4->2 then both meet at 4
		Node slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast)
			return;
		Node t1 = slow.next;
		int k = 1;
		while (t1 != slow) {
			k++;
			t1 = t1.next;
		}
		t1 = head;
		while (k > 0) {
			k--;
			t1 = t1.next;
		}
		Node prev = null, curr = head;
		while (t1 != null && curr != null && t1 != curr) {
			prev = t1;
			t1 = t1.next;
			curr = curr.next;
		}
		prev.next = null;
	}
}