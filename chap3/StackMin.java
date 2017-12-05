package ctci.chap3;

public class StackMin implements MyStack<Integer>{
	
	private class ValueAndMin{
		public Integer value;
		public Integer min;
		public ValueAndMin(Integer value,Integer min){
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

	public void push(Integer value){
		ValueAndMin vam;
		if(top == null){
			vam = new ValueAndMin(value,value);
			top = new StackNode(vam);
		}else{
			Integer newMin = (top.obj.min > value)? value : top.obj.min;
			vam = new ValueAndMin(value, newMin);
			int x = vam.value;
			StackNode nextTop = new StackNode(vam);
			nextTop.previousNode = top;
			top = nextTop;
		}
	}

	public Integer pop(){
		if(top == null){ throw new IllegalStateException("Nothing in the stack to pop.");}
		StackNode oldTop = top;
		top = top.previousNode;
		return ((ValueAndMin)oldTop.obj).value;
	}

	public Integer peek(){
		if(top == null){ throw new IllegalStateException("Nothin in stack to peek.");}
		return top.obj.value;
	}

	public Integer min(){
		if(top == null){ throw new IllegalStateException("Nothing in stack");}
		return top.obj.min;
	}

}