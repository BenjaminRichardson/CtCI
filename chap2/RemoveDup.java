package ctci.chap2;

import java.util.*;
import ctci.ctciLibrary.*;

public class RemoveDup{
	
	// Assuming we start from head always. 
	public static void deleteDups(LinkedListNode first){
		Set<Integer> observedData = new HashSet<Integer>();
		LinkedListNode currNode = first;
		while(currNode != null){
			if(observedData.contains(currNode.data)){
				currNode.prev.setNext(currNode.next);
				if(currNode.next != null){
					currNode.next.setPrevious(currNode.prev);
				}
			}else{
				observedData.add(currNode.data);
			}
			currNode = currNode.next;
		}

	}

	public void deleteDupsSmall(LinkedListNode first){
		LinkedListNode currNode = first.next;
		while(currNode!=null){
			LinkedListNode comparisonNode = first;
			boolean noMatch = true;
			while(comparisonNode != currNode && noMatch){
				if(currNode.data == comparisonNode.data){
					noMatch = false; // We've found a node earlier in the list which matches.
				}
				comparisonNode = comparisonNode.next;
			}
			// Meaning we did find a dup earlier in the list
			if(!noMatch){
				currNode.prev.setNext(currNode.next);
				if(currNode.next != null){
					currNode.next.setPrevious(currNode.prev);
				}
			}
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode first = AssortedMethods.randomLinkedList(100000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());

		LinkedListNode cloneA = head.clone();
		LinkedListNode cloneB = head.clone();
		LinkedListNode cloneC = head.clone();
		deleteDups(cloneA);
		deleteDups(cloneB);
		deleteDups(cloneC);
		
		System.out.println(cloneA.printForward());
		System.out.println(cloneB.printForward());
		System.out.println(cloneC.printForward());
	}
}