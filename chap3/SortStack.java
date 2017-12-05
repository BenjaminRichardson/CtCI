package ctci.chap3;

import java.util.Stack;

public class SortStack{
	
	// Done modifying the the stack passed in, unlike the book
	public static void sortStack(Stack<Integer> s){
		if(s== null || s.size() < 2){ return; }
		Stack<Integer> sortedStack = new Stack<Integer>(); // sort so that the biggest items are on the top
		while(!s.isEmpty()){
			Integer currItem = s.pop();
			int swapCount = 0;
			while(!sortedStack.isEmpty() && currItem.compareTo(sortedStack.peek()) > 0){
				s.push(sortedStack.pop());
				swapCount++;
			}
			sortedStack.push(currItem);
			for(int i=0;i<swapCount;i++){
				sortedStack.push(s.pop());
			}
		}
		//Reversing the sorting order
		while(!sortedStack.isEmpty()){
			s.push(sortedStack.pop());
		}
	}
}