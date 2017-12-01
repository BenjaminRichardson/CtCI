package ctci.chap2;

import ctci.ctciLibrary.LinkedListNode;

// I don't like the recurrsive solution provided by Gayle McDowell, it creates a lot of overhead when dealing with large lists. 
// As I understand it iterative solutions are prefered in Java, especially since it doesn't support tail recursion optimization.
public class SumLists{

	// I assumed we had a singly linked list
	// This is a good example of why big O is not the end-all be-all. The solution in book can do this is in one traversal (even accounting for SLL)
	// This solution is O(n) as well, but it has to do two traversals of lists of length n (technically O(2n)), which is going to be much worse in practice.
	// To fix I just have to send the carry backwards, similar to the ascending solution. 	
	public static LinkedListNode sumListsDescending(LinkedListNode n1, LinkedListNode n2){
		int sum = 0;
		while(n1 != null || n2 != null){
			sum *= 10;
			sum += n1.data + n2.data;
			n1 = n1.next;
			n2 = n2.next;
		}
		while(n1 != null){
			sum *= 10;
			sum += n1.data;
			n1 = n1.next;
		}
		while(n2 != null){
			sum *= 10;
			sum += n2.data;
			n2 = n2.next;
		}

		//create a new list from the values
		if(sum == 0){ return new LinkedListNode(0); }
		LinkedListNode nextNode = null; // "in front" of current node, the last node we were working with
		LinkedListNode currNode = null;
		while(sum != 0){
			if(currNode == null){
				currNode = new LinkedListNode(sum % 10);
			}else{
				nextNode = currNode;
				currNode = new LinkedListNode(sum % 10);
				currNode.setNext(nextNode);
			}
			sum /= 10;
		}
		return currNode;
	}

	public static int LinkedListToIntDescending(LinkedListNode head){
		int value = 0;
		LinkedListNode currNode = head;
		while(currNode != null){
			value *= 10;
			value += currNode.data;
			currNode = currNode.next;
		}
		return value;
	}

	// Assuming we cannot modify the two lists being summed
	public static LinkedListNode sumListsAscending(LinkedListNode n1, LinkedListNode n2){
		int carryOver = 0;
		LinkedListNode returnHead = new LinkedListNode(); // placeholder head which makes loop cleaner, we will not return this value;
		LinkedListNode currNode = returnHead;
		while(n1 != null || n2 != null){
			int currSum = n1.data + n2.data + carryOver;
			carryOver = currSum /10;
			currNode.setNext(new LinkedListNode(currSum % 10));
			currNode = currNode.next;
			n1 = n1.next;
			n2 = n2.next;
		}
		//in case one is longer than the other, only one of these blocks will be run in a single call
		while(n1 != null){
			int currSum = carryOver + n1.data;
			carryOver = currSum/10;
			currNode.setNext(new LinkedListNode(currSum % 10));
			currNode = currNode.next;
			n1 = n1.next;
		}
		while(n2 != null){
			int currSum = carryOver + n2.data;
			carryOver = currSum/10;
			currNode.setNext(new LinkedListNode(currSum % 10));
			currNode = currNode.next;
			n2 = n2.next;
		}
		if(carryOver != 0){
			currNode.setNext(new LinkedListNode(carryOver));
		}
		returnHead = returnHead.next;
		returnHead.setPrevious(null); // removing the filler head we created at the start. Not needed if true SLL
		return returnHead;
	}

	// Assuming digits are from least significant to most significant
	public static int linkedListToIntAscending(LinkedListNode head){
		int value = 0;
		int digitPlace = 1;
		LinkedListNode currNode = head;
		while(currNode != null){
			value += digitPlace*currNode.data;
			digitPlace *= 10;
			currNode = currNode.next;
		}
		return value;
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = sumListsDescending(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = LinkedListToIntDescending(lA1);
		int l2 = LinkedListToIntDescending(lB1);
		int l3 = LinkedListToIntDescending(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		


	}
}