package ctci.chap3;

import java.util.Stack;

public class QueueFromStack{
	
	private Stack<Integer> front;
	private Stack<Integer> back;

	public QueueFromStack(){
		front = new Stack<Integer>();
		back = new Stack<Integer>();
	}

	public void enqueue(int num){
		back.push(num);
	}

	public int getSize(){
		return front.size() + back.size();
	}

	public int dequeue(){
		if(front.isEmpty()){
			rollOver();
		}
		if(front.isEmpty()){
			throw new NoSuchElementException("Error nothing in queue.");
		}
	}

	private void rollOver(){
		while(!back.isEmpty()){
			front.push(back.pop());
		}
	}

}