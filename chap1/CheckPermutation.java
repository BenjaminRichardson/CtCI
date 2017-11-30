
package ctci.chap1;
import java.util.*;
/*
* 1.2: Given two strings, write a method to decide if one is a permutation of the other
*/

public class CheckPermutation{

	public static void main(String args[]){
		String[] testSet = {"one two three four", "hello hello",
							"wow dad racecar dad","daddadracecarwow   ",
							"who is this", "this is who",
							"", ""
							};
		for(int i=0; i<testSet.length/2; i++){
			System.out.println(i + ": "+ isPermutation(testSet[i*2],testSet[2*i+1]));
		}
		System.out.println(isPermutation(null,null));

	}

	public static boolean isPermutation(String s1, String s2){
		if(s1 == null || s2 == null){ return true; }
		if(s1.length() != s2.length()){ 
			System.out.println("false here");
			return false;
		}

		Map<Character,Integer> charCount = new HashMap<Character,Integer>();

		char[] letters1 = s1.toCharArray();
		for (int i=0; i<letters1.length; i++){
			char currChar = letters1[i];
			if (charCount.get(currChar) != null){
				int oldCount = charCount.get(currChar);
				charCount.put(currChar,oldCount+1);
			}else{
				charCount.put(currChar,1);
			}
		}
		char[] letters2 = s2.toCharArray();
		for(int i=0; i<letters2.length; i++){
			char currChar = letters2[i];
			Integer oldCount = charCount.get(currChar);
			if(oldCount == null || oldCount-1 <0){
				return false;
			}
			if(oldCount-1 ==0){
				charCount.remove(currChar);
			}else{
				charCount.put(currChar,oldCount-1);
			}
		}
		if(charCount.isEmpty()){
			return true;
		}else{
			return false;
		}

	}

}
