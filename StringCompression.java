package ctci;

/*
* Assume only character a-z (lower case
* null and empty string null
*/
public class StringCompression{
	
	public static void main(String[] args){
		String[] inputOutputPairs = {"aaabbbcccddd","a3b3c3d3",
									"abcccddd","a1b1c3d3",
									"",null,
									null,null,
									"aabbcccccddaacc","a2b2c5d2a2c2",
									"a","a"
									};
		for(int i=0; i<inputOutputPairs.length; i+=2){
			if(stringCompression2(inputOutputPairs[i]) == null){
				if(inputOutputPairs[i+1] != null){
					System.out.println("Error: Failed test "+(i/2+1)+".");
				}
			}else{
				if(!stringCompression(inputOutputPairs[i]).equals(inputOutputPairs[i+1])){
					System.out.println("Error: Failed test "+(i/2+1)+".");
				}
			}
		}
		System.out.println("Finished.");
	}

	public static String stringCompression(String str1){
		if(str1 == null || str1.isEmpty()){ return null; }

		StringBuilder sb = new StringBuilder();
		char[] strAsChars = str1.toCharArray();
		char previousChar = strAsChars[0]; //filler character (Assuming only a-z)
		int count = 1;
		for(int i=1; i<strAsChars.length; i++){
			char currChar = strAsChars[i];
			if(currChar == previousChar){
				count++;
			}else{
				sb.append(previousChar);
				sb.append(Integer.toString(count));
				count = 1;
				previousChar = currChar;
			}
		}
		sb.append(previousChar);
		sb.append(Integer.toString(count));
		String returnVal = sb.toString();
		// This is inefficient! do the check first
		if(returnVal.length() > str1.length()){
			return str1;
		}
		return returnVal;
	}

	/*Based on the "best" solution from the Cracking the Coding Interview book
	First need to determine the length, then if shorter actually do the string building*/

	public static String stringCompression2(String str){
		if(str == null || str.isEmpty()){ return null; }
		int compressedLength = compressedStringCount(str);
		if(compressedLength >= str.length()){
			return str;
		}
		StringBuilder sb = new StringBuilder(compressedLength);
		char previousChar = str.charAt(0) ;
		char currChar;
		int prevCharCount = 1;
		for(int i=1; i<str.length(); i++){
			currChar = str.charAt(i);
			if(currChar != previousChar){
				sb.append(previousChar);
				sb.append(String.valueOf(prevCharCount));
				previousChar = currChar;
				prevCharCount = 1;
			}else{
				prevCharCount++;
			}
		}
		sb.append(previousChar);
		sb.append(String.valueOf(prevCharCount));
		return sb.toString();
	}

	public static int compressedStringCount(String str){
		if(str==null || str.length() == 0){return 0;}
		char lastChar = str.charAt(0);
		int totalCount = 0;
		int currentCount = 1;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) != lastChar){
				totalCount += 1 + String.valueOf(currentCount).length();
				currentCount = 1;
				lastChar = str.charAt(i);
			}else{
				currentCount++;
			}
		}
		totalCount += 1 + String.valueOf(currentCount).length();
		return totalCount;
	}
}