package ctci.chap3;

public class ThreeInOneStack<T>{
	private static final int STARTING_STACK_SIZE = 3;
	private T[] storage;
	private T[] storageShadow;
	private int[] itemCount;

	public ThreeInOneStack(){
		storage = new T[STARTING_STACK_SIZE*3];
		storageShadow = new T[storage.length*2];
		itemCount = {0,0,0}; // the count of each stack
	} 

	public T peek(int stackIndex){
		if(stackNum > 2){ throw new IllegalArgumentException("Stack Number must be between 0 and 2 inclusive"); }
		return storage[(itemCount[stackIndex]-1)*3 + stackIndex];
	}

	public T pop(int stackIndex){
		if(stackNum > 2){ throw new IllegalArgumentException("Stack Number must be between 0 and 2 inclusive"); }
		if(itemCount[stackIndex] == 0){throw new IllegalArgumentException("That stack is empty")}
		itemCount[stackIndex]--;
		storage[itemCount[stackIndex]*3 + stackIndex] = null;
		copyShadow(itemcount[stackIndex],stackIndex);
		return storage[itemCount[stackIndex]*3 + stackIndex];
	}

	public void push(int stackNum, T value){
		if(stackNum > 2){ throw new IllegalArgumentException("Stack Number must be between 0 and 2 inclusive"); }
		if((itemCount[stackNum]+1)*3 >= storage.length){
			storage = storageShadow;
			storageShadow = new T[storage.length*2];
		}
		storage[itemCount[stackNum]*3+stackNum] = value;
		copyShadow(itemCount[stackNum],stackNum);
		itemCount[stackNum]++;
	}

	private void copyShadow(int blockNum, int offSet){
		shadowStorage[blockNum*3+offset] = storage[blockNum*3+offset];
		// copy old values at half current index.
		// before we expand again we will have to go through each blockNumber above half at least once before we grow
		if(blockNum*3 >= storage.length/2){
			int halfBlockNum = blockNum*3-storage.length/2;//will always be divisible by two since we always double the size
			shadowStorage[halfBlockNum] = storage[halfBlockNum];
			shadowStorage[halfBlockNum + 1] = storage[halfBlockNum + 1] 
			shadowStorage[halfBlockNum + 2] = storage[halfBlockNum + 2];
		}
	}
}