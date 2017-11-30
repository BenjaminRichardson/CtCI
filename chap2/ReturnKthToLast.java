package ctci.chap2;
import ctci.ctciLibrary.*;

public class ReturnKthToLast{
	
	// Pretending LinkedList is singly linked and we don't have last node
	// Assuming there are at least count number of items
	// Assuming we don't know the length of the list (but I should remember to ask in interview)
	public static LinkedListNode kthToLast(LinkedListNode head, int count){
		LinkedListNode kBefore = head;
		LinkedListNode currNode = head;
		for(int i = 0; i<count ;i++){
			if(currNode == null){
				return null; // sitation where there aren't even k items in list
			}
			currNode = currNode.next;
		}

		while(currNode != null){
			kBefore = kBefore.next;
			currNode = currNode.next;
		}

		return kBefore; //because third to last, includes the last node
	}

	// Taken from CtCI github page
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = kthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}

}