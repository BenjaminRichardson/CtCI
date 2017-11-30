package ctci.chap1;

/*
* Note: I have assumed that the length of str fits the new string exactly.
*/

public class URLify{
	public static void main(String args[]){
		String[] testStrings = {"hello","this is a test", ""}
		printResult()
	}

	public static void toURL(char[] str, int length){
		if(str.length == 0 || length == 0){ return; }

		int urlStringPosition = str.length-1;
		int rawStringPosition = length-1;
		while(rawStringPosition >= 0){
			char currChar = str[rawStringPosition];
			if(currChar == ' '){
				insertURLSpace(str,urlStringPosition-2);
				urlStringPosition -= 3;
			}else{
				str[urlStringPosition] = currChar;
				urlStringPosition -= 1;
			}

			rawStringPosition -= 1;
		}
	}

	public static void insertURLSpace(char[] str, int startPosition){
		str[startPosition] = '%';
		str[startPosition+1] = '2';
		str[startPosition+2] = '0';
	}
}
