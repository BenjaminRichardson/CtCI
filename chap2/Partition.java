package ctci.chap2;
import ctci.ctciLibrary.*;

public class Partition{
	
	// Assuming doublely linked list (though it would easy to extend to single linked list, just track the previous node)
	// This is a little funky since I imagined that we wanted to keep the head the head (this function would be void)
	// Clearly the Author of CtCI was not thinking this way and the method signature shows that.
	public static LinkedListNode partition(LinkedListNode head, int val){
		LinkedListNode currNode = head.next;
		while(currNode != null){
			LinkedListNode nextEval = currNode.next;
			if(currNode.data < val){
				if (head.data >= val){
					// A little hacky, but there's not much you can do if the head in right partition
					int temp = head.data;
					head.data = currNode.data;
					currNode.data = temp;
				}else{
					// Remove currNode from current location
					currNode.prev.setNext(currNode.next);
					if(currNode.next != null){
						currNode.next.setPrevious(currNode.prev);
					}

					// Put currNode in place directly after head
					currNode.setNext(head.next);
					head.next.setPrevious(currNode);
					head.setNext(currNode);
					currNode.setPrevious(head);
				}
			}
			currNode = nextEval;
		}
		return head;
	}

	public static LinkedListNode createLinkedList() {
		/* Create linked list */
		int[] vals = AssortedMethods.randomArray(15,0,30);
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(createLinkedList().printForward());
		
		/* Partition */
		LinkedListNode hA = partition(createLinkedList(), 15);
		LinkedListNode hB = partition(createLinkedList(), 15);
		LinkedListNode hC = partition(createLinkedList(), 15);
		
		/* Print Result */
		System.out.println(hA.printForward());
		System.out.println(hB.printForward());
		System.out.println(hC.printForward());
	}

}