package ctci.chap2;

import ctci.ctciLibrary.LinkedListNode;
import java.util.*;

public class LoopDetection{
	
	// Inspired by the book's solution, definitely the low space way of doing this problem
	public static LinkedListNode detectLoopLowSpace(LinkedListNode head){
		if(head == null ){ return null; }
		LinkedListNode slowNode = head;
		LinkedListNode fastNode = head;
		do{
			if(slowNode.next == null){ return null; }
			slowNode = slowNode.next;
			if(fastNode.next == null || fastNode.next.next == null){ return null; }
			fastNode = fastNode.next.next;
		}while(slowNode != fastNode);
		// This works because the colision between fast and slow always occurs length of loop - steps to loop nodes from start of loop. 
		//If we move at the same rate in both the tracer and the inner loop we'll hit the start at the same point.
		// This is nice because we don't have to worry about storing everything in the loop 
		LinkedListNode tracer = head;
		while(tracer != slowNode){
			tracer = tracer.next;
			slowNode = slowNode.next;
		}
		return tracer;
	}

	// O(n) space, O(n) time
	public static LinkedListNode detectLoop(LinkedListNode head){
		Set<LinkedListNode> observedNodes = new HashSet<LinkedListNode>();
		LinkedListNode currNode = head;
		while(currNode != null){
			if(observedNodes.contains(currNode)){
				return currNode;
			}
			observedNodes.add(currNode);
			currNode = currNode.next;
		}
		return null;
	}

	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = detectLoop(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println("Hash: "+loop.data);
		}

		loop = detectLoopLowSpace(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println("Two Pointer: "+loop.data);
		}
	}
}