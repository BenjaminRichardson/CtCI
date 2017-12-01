package ctci.chap2;

import ctci.ctciLibrary.*;

public class Intersection{
	
	// Based on solution in the book, better time performance, same space as my space conservative solution
	public static LinkedListNode intersection3(LinkedListNode h1, LinkedListNode h2){
		LinkedListNode t1 = h1,t2 = h2;
		int count1=1, count2=1;
		while(t1.next != null){
			t1 = t1.next;
			count1++;
		}
		while(t2.next != null){
			t2 = t2.next;
			count2++;
		}
		if(t2 != t1){ return null; }

		LinkedListNode longer,shorter;
		int countDiff = (count1>count2)? count1-count2 : count2-count1;
		longer = count1>count2? h1:h2;
		shorter = count1>count2? h2:h1;
		for(int i=0;i<countDiff;i++){
			longer = longer.next;
		}
		while(longer != shorter){
			longer = longer.next;
			shorter = shorter.next;
		}
		return longer;
	}

	// Solution where space is a priority
	public static LinkedListNode intersection2(LinkedListNode h1,LinkedListNode h2){
		LinkedListNode l1=h1, l2=h2;
		while(l1 != null){
			l2 = h2;
			while(l2 != null){
				if(l1 == l2){ return l1; } // this will always capture the point of intersection becuase we are going in order in both lists
				l2 = l2.next;
			}
			l1 = l1.next;
		}
		return null;
	}

	// Solution where time is a priority
	public static LinkedListNode intersection1(LinkedListNode h1, LinkedListNode h2){
		LinkedListNode l1 = h1,l2=h2;
		Map<LinkedListNode> map = new HashMap<LinkedListNode>(); // BEEG
		while(l1 != null){
			map.add(l1);
			l1 = l1.next;
		}
		while(l2 != null){
			if(map.contains(l2)){// this will be the intersecting node because it is the first one in the chain
				return l2;
			}
			l2 = l2.next;
		}
		return null;
	}

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}
}