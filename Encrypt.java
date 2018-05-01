package base;

import java.util.Arrays;

public class Encrypt {

	public void encryptM (String message, int num) {
		
		String t = "";
		for (int i = 0; i < message.length(); ++i) {
		    char ch = message.charAt(i);
		    if (!t.isEmpty()) {
		        t += " ";
		    }
		    int n = (int)ch - (int)'a' + 1;
		    t += String.valueOf(n);
		}
		System.out.println(t);
		
		// The string you want to be an integer array.
		String[] integerStrings = t.split(" "); 
		// Splits each spaced integer into a String array.
		int[] integers = new int[integerStrings.length]; 
		// Creates the integer array.
		for (int i = 0; i < integers.length; i++){
		    integers[i] = Integer.parseInt(integerStrings[i]); 
		//Parses the integer for each string.
		}
		

		for (int i = 0; i < integers.length; i++)
		    integers[i] = integers[i] * num;  
		
		
		System.out.println("Encrypted Message: " + Arrays.toString(integers));
		
		
	}
	
	public void decryptM (int integers[], int num) {
		
		
		for (int i = 0; i < integers.length; i++)
		    integers[i] = integers[i] / num;  
		
        String[] decoded = new String[integers.length];

		for (int i = 0; i < integers.length; i++) {
			
			decoded[i] = String.valueOf(Character.toChars(integers[i] + 64));
			
		}
			
		String decodedE = String.join("", decoded);

	    System.out.println("Decoded: " + decodedE);
	}
	
	public int parseD (String i) throws NumberFormatException {
		int num = 0;
		try {
    		num = Integer.parseInt(i);
		} catch (NumberFormatException e1) {
			System.out.println("Please enter a number");
		}
		return num;
				
		
	}
	
}