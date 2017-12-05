package ctci.chap3;

import java.util.List;
import java.util.ArrayList;

public class SetOfStacks implements MyStack<Integer>{
	
	private static final int STACK_CAPACITY = 100;

	private class SimpleStack{
		private Integer[] stack;
		private int top;
		public SimpleStack(){
			stack = new Integer[STACK_CAPACITY];
			top = -1;
		}

		public Integer pop(){
			if(top == -1 ){ return null; }
			top--;
			return stack[top + 1];
		}

		public boolean push(Integer obj){
			if(top+1 >= STACK_CAPACITY){ return false; }
			top++;
			stack[top] = obj;
			return true;
		}

		public Integer peek(){
			if(top == -1){ return null;}
			return stack[top];
		}
	}

	private List<SimpleStack> stackList;
	private int currStackIndex;

	public SetOfStacks(){
		stackList = new ArrayList<SimpleStack>();
		currStackIndex = -1;
	}

	public void push(Integer obj){
		if(obj == null){ return; }// Assume we can't have null values in the list
		if(currStackIndex == -1 || !stackList.get(currStackIndex).push(obj)){
			stackList.add(new SimpleStack());
			currStackIndex++;
			this.push(obj);
		}
	}

	public Integer pop(){
		if(currStackIndex == -1){ return null; }
		Integer returnVal = stackList.get(currStackIndex).pop();
		if(returnVal == null){
			stackList.remove(currStackIndex);
			currStackIndex--;
			return this.pop();
		}
		return returnVal;
	}

	public Integer peek(){
		if(currStackIndex == -1){ return null;}
		Integer returnVal = stackList.get(currStackIndex).peek();
		if(returnVal == null){
			stackList.remove(currStackIndex);
			currStackIndex--;
			return this.peek();
		}
		return returnVal;
	}
}