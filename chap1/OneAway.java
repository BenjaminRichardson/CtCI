package ctci.chap1;

/*
* Assumptions: null is never one away from anything
*/

public class OneAway{
	
	public static void main(String[] args){
		//Quick and easy way to test function
		String[] inputs 			= { "pale", "ple",
										"pales", "pale",
										"pale", "bale",
										"pale", "bae",
										"", "a",
										"a", "",
										"", "abd",
										null,null};

		boolean[] expectedResults 	= {true,
										true,
										true,
										false,
										true,
										true,
										false,
										false};

		if(2*expectedResults.length != inputs.length){ 
			System.out.println("Error: inputs and reuslts do not match.");
			System.exit(0);
		}

		for(int i=0; i<expectedResults.length;i++){
			if(isOneAway(inputs[2*i],inputs[2*i+1])!= expectedResults[i]){
				System.out.println("Error in test case "+i+".");
			}
		}
		System.out.println("Success!");
	}

	public static boolean isOneAway(String s1, String s2){
		if(s1 == null || s2 == null){ return false; }

		String longer;
		String shorter;
		if(s1.length() > s2.length()){
			longer = s1;
			shorter = s2;
		}else{
			longer = s2;
			shorter = s1;
		}
		if(longer.length() - shorter.length() > 1){
			return false;
		}


		boolean difference = false;
		for(int i=0, j=0; i<shorter.length(); i++,j++){
			if(longer.charAt(j) == shorter.charAt(i)){ continue; }
			if(longer.length() == shorter.length()){
				if(difference){
					return false;
				}
				difference = true;
			}else{
				if(difference || longer.charAt(j+1) != shorter.charAt(i)){
					return false;
				}
				j++;
				difference = true; //this is our protection from out of bounds on charAt
			}
		}
		return true;
	}
}
