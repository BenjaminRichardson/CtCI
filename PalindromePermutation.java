package ctci;

/*
*	Assumptions: 
		* Empty and null strings are not palindromes
		* We are only dealing with ascii characters [0-127]
*/

public class PalindromePermutation{
	public static void main(String args[]){
		
	}

	public static boolean canBePalindrome(String str){
		if(str == null || str.isEmpty()){ return false; }
		// We don't actually care about the count, only whether the character appears an even or odd number of times. 
		boolean[] charIsOdd = new boolean[128]; // defaults value is false (which is what we want)
		int numOdds = 0;
		for(char c: str.toCharArray()){
			if(charIsOdd[c]){
				numOdds--;
			}else{
				numOdds++;
			}
			charIsOdd[c] = !charIsOdd[c];
		}
		if(numOdds > 1){
			return false;
		}else{
			return true;
		}

	}

}