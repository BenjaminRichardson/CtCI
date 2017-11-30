package ctci.chap1;

public class StringRotation{
	
	// Only allowed one call to isSubstring
	// check if s2 is rotation of s1
	public static boolean isRotation(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){ return false; } 
		if(s1.length() != s2.length()) { return false; }
		int matchStartIndex = -1;
		int i = 0;
		for( int j = 0; j<s2.length(); j++){
			//want to find place where the start lines up
			if(s1.charAt(i) == s2.charAt(j)){
				if(matchStartIndex == -1){
					matchStartIndex = j ;
				}
				i++;
			}else{
				matchStartIndex = -1;
				i = 0;
			}
			
		}
		// i is where the similariy ends
		if(matchStartIndex == -1){
			return false; // no match for the beginning found
		}
		return isSubstring(s1,s2.substring(0,matchStartIndex));//This is very bad becuase substring is another list iteration
	}

	// Based on book's answer, pretty clever if you ask me
	public static boolean isRotation2(String s1, String s2){
		if(s1.length() != s2.length() || s1.length() < 1){ return false; }
		String testString = s1+s1;
		return isSubstring(testString,s2);
	}

	// Taken from ctci.chap1 github, we were supposed to assume we had such a function created
	public static boolean isSubstring(String big, String small) {
		//System.out.println(big+" is big but "+small+" is small");
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
