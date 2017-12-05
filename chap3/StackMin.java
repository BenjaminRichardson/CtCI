package ctci.chap3;

public class StackMin{
	
	private class ValueAndMin{
		public int value;
		public int min
		public ValueAndMin(int value,int min){
			this.value = value;
			this.min = min;
		}
	}

	private class StackNode<G>{
		public StackNode<G> previousNode;
		public G obj;
		public StackNode(G value){
			this.obj = value;
		}
	}

	private StackNode<ValueAndMin> top;

	public StackMin(){
		top = null;
	}

	public void push(T value){
		ValueAndMin vam;
		if(top == null){
			vam = new ValueAndMin(value,value);
			top = new StackNode(vam);
		}else{
			int newMin = (top.obj.min > value)? value : top.obj.min;
			vam = new ValueAndMin(value, newMin);
			StackNode nextTop = new StackNode(vam);
			nextTop.previousNode = top;
			top = nextTop;
		}
	}

	public int pop(){
		if(top == null){ throw new IllegalStateException("Nothing in the stack to pop.");}
		StackNode oldTop = top;
		top = top.previousNode;
		return oldTop.obj.value;
	}

	public int peek(){
		if(top == null){ throw new IllegalStateException("Nothin in stack to peek.");}
		return top.obj.value;
	}

	public int min(){
		if(top == null){ throw new IllegalStateExcpetion("Nothing in stack");}
		return top.obj.min;
	}

}