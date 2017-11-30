
package ctci.chap1;
import java.util.*;
/*
*  1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters
*  1.1A use no additional data structures
*/
public class IsUnique{
	
	public static void main(String args[]){
		String word = args[0];
		System.out.println(isUnique(word));
		System.out.println(isUniqueAdvanced(word));
	}

	public static boolean isUnique(String word){
		if(word==null || word.length() < 2){
			return true;
		}
		int n = word.length();
		if(n > 26){
			return false;
		}
		Set<Character> s = new HashSet<Character>();
		char[] letters = word.toCharArray();
		char letter;
		for(int i=0; i<n; i++ ){
			letter = letters[i];
			if(s.contains(letter)){
				return false;
			}else{
				s.add(letter);
			}
		}
		return true;
	}  

	public static boolean isUniqueAdvanced(String word){
		if(word == null|| word.length() < 2){ return true;}
		if(word.length() > 128){ return false; }
		boolean[] letters = new boolean[128];
		for(int i=0; i< word.length(); i++){
			int currLetter = Character.toLowerCase(word.charAt(i)); // has to be int!
			if(letters[currLetter]){
				return false;
			}else{
				letters[currLetter] = true;
			}
		}
		return true;
	}
}

/*
* Note: not just letters, but all ascii symbols so extend to array of size 128
*/

