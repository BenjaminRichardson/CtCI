package ctci.chap2;

import ctci.ctciLibrary.AssortedMethods;
import ctci.ctciLibrary.LinkedListNode;

public class DeleteMiddleNode{
	
	// Assuming singly linked list
	// Can't delete if node is last the list, but could potentially flag as "end" by filling in some dummy data
	public static void deleteNode(LinkedListNode node){
		if(node == null || node.next == null){ return; }
		node.data = node.next.data;
		node.next = node.next.next;
	} 

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}	
}