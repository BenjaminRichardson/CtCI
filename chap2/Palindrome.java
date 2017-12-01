package ctci.chap2;

import java.util.*;
import ctci.ctciLibrary.LinkedListNode;

public class Palindrome{
	
	// Assuming doubly linked list
	// This is nice from a space perspective, but not the best time-wise
	public static boolean isPalindrome(LinkedListNode head){
		if(head == null){ return false; }
		LinkedListNode tail = head;
		int listCount = 1;
		while(tail.next != null){
			tail = tail.next;
			listCount ++;
		}
		LinkedListNode front = head;
		LinkedListNode back = tail;
		int currCount = 0;
		while(front != back || currCount < listCount/2){
			if(front.data != back.data){
				return false;
			}
			front = front.next;
			back = back.prev;
			currCount++;
		}
		return true;
	}

	// Based on solution 2 in the book, more space usage but only 1 iteration over the list
	public static boolean isPalindrome2(LinkedListNode head){
		if(head == null){ return false; }

		LinkedListNode slowNode = head;
		LinkedListNode fastNode = head;
		Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
		boolean tailFound = false;
		boolean oddLength = true;
		while(!tailFound){
			stack.push(slowNode);
			slowNode = slowNode.next;

			if(fastNode.next != null){
				fastNode = fastNode.next;
				if(fastNode.next != null){
					fastNode = fastNode.next;
				}else{
					tailFound = true;
					oddLength = false;
				}
			}else{
				tailFound = true;
				oddLength = true;
			}
		}

		if(oddLength){
			stack.pop();// remove top element becuase we don't want to consider middle
		}
		while(slowNode != null){
			if(stack.peek().data != slowNode.data){
				return false;
			}
			slowNode = slowNode.next;
			stack.pop();
		}
		return true;
	}

	public static void main(String[] args) {
		int max = 11;
		for (int length = 1; length < max; length++) {
			LinkedListNode[] nodes = new LinkedListNode[length];
			for (int i = 0; i < length; i++) {
				nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
			}
			for (int i = 0; i < length; i++) {
				if (i < length - 1) {
					nodes[i].setNext(nodes[i + 1]);
				}
				if (i > 0) {
					nodes[i].setPrevious(nodes[i - 1]);
				}
			}
			for (int i = -1; i < length; i++) {
				if (i >= 0) {
					nodes[i].data++; // Ruin palindrome
				}
				
				LinkedListNode head = nodes[0];
				System.out.println(head.printForward());
				boolean resultA = isPalindrome(head);
				boolean resultB = isPalindrome2(head);
				System.out.println("A: " + resultA);
				System.out.println("B: " + resultB);
				if (resultA != resultB ) {
					System.out.println("ERROR");
					length = max;
					break;
				}
				if (i >= 0) {
					nodes[i].data--;
				}
			}
		}
	}
}