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
			if(stringCompression(inputOutputPairs[i]) == null){
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
		if(returnVal.length() > str1.length()){
			return str1;
		}
		return returnVal;
	}
}