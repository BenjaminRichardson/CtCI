package ctci.chap3;

public class StackTester{
	
	public static void main(String[] args){
		MyStack<Integer> s = new StackMin();
		basicStackTests(s);
		StackMin ms = new StackMin();
		minTest(ms);
		System.out.println("Complete.");
	}

	public static void minTest(StackMin s){
		int[] stackVals = new int[100];
		s.push(50);
		if(s.min() != 50){ System.out.println("Simple min case failed"); }
		for(int i=0; i<100;i++){
			stackVals[99-i] = i;
			s.push(i);
		}
		for(int i=0;i<100;i++){
			if(s.min() != 0){ System.out.println("Min consistency failed");}
			s.pop();
		}
		if(s.min() != 50){ System.out.println("Min reset failed"); }
	}

	public static void basicStackTests(MyStack<Integer> s){
		int[] stackVals = new int[100];
		for(int i=0; i<100;i++){
			stackVals[99-i] = i;
			s.push(i);
		}
		for(int i=0;i<50;i++){
			if(s.peek() != stackVals[i] || s.pop() != stackVals[i]){ 
				System.out.println("Error: Simple insertion failed.");
			}
		}
		for(int i=0;i<25;i++){
			s.push(i);
		}
		for(int i=24;i>=0;i--){
			if(s.peek() != i || s.pop() != i){
				System.out.println("Error: Secondary Insertion failed.");
			}
		}
		for(int i=0;i<50;i++){
			if(s.pop() != 49-i){
				System.out.println("Error: Stack empty failed.");
			}
		}
	}
}
