package base;
import java.util.Scanner;

public class Main {
	
	
    public static void main(String[] args) {
    	
    	//Start the object e for AlphaNum encryptions
		Encrypt e = new Encrypt();

		// create a new scanner with the specified String Object
        Scanner scanner = new Scanner(System.in);
        
        //Welcome Text and makes an line with no text to seperate the actual encryption/decryption
        System.out.println("SafeFile 2018 Java Version");
        System.out.println("Liscenced with Apache Liscence, Version 2.0");
        System.out.println();
        
        //Check if user wants to encrypt or decrypt
        System.out.println("Would you like to Encrypt or Decrypt (Select one in the same spelling)");
        String EorD = scanner.next();
        
        if (EorD.equals("Encrypt")) {
        	
        Scanner scanner1 = new Scanner(System.in);

    	//Check how the user wants to encrypt
    	System.out.println("How Would You Like to Encrypt? - Available Currently: Ceaser Cypher, Alpha Number Encryption");
    	System.out.println("For Ceaser Cypher, enter Ceaser, For Alpha Number, enter AlphaNum"); //More would be added in as more encryption ways are added into the program
    	
    	String howE = scanner.next();
    	
    	if (howE.equals("Ceaser")) {
    		
            System.out.println("What is the text you would like to encrypt?");
            String textE = scanner1.next();
            
            System.out.println("What is the offset for the Ceaser Cypher? Enter 0 for an random offset");
    		String numE = scanner1.next();
    				
    		int numEi = Integer.parseInt(numE);
    	
    		if (numEi == 0) {	
    			Ran r = new Ran();
    			numEi = r.ran();	
    		}
    		
    		String encrypted = Encrypter.encode(textE, numEi);
            
    		System.out.println("Below is encrypted Text with Ceaser Cypher, offset of " + numEi);
    		System.out.println(encrypted);
    		
    		System.out.println("please reload the application again if you want to do another calculation");

            // close the scanner
            scanner1.close();
            
        		
        	} else if (howE.equals("AlphaNum")) {
        		
        		
        		System.out.println("Please enter the message to encrypt with NO SYMBOLS(symbols will look weird afterwards) :");
        		String s = scanner1.nextLine();
        		
        		System.out.println("How much do you want to multiply the encryption (The bigger the better but slower) NO DECIMALS");
        		String numS = scanner1.nextLine();
        		int num = Integer.parseInt(numS);
        		
    			e.encryptM(s, num);
        		
    			
        	}
    	
        } else if (EorD.equals("Decrypt")){
        		
        		System.out.println("Decrypting message");
        	
        		//Asks the user how they want to decrypt
            	System.out.println("How Would You Like to Decrypt? - Available Currently: Ceaser Cypher, Alpha Numeric");
            	System.out.println("For Ceaser Cypher, enter Ceaser. For Alpha Numeric, enter AlphaNum"); //More would be added in as more encryption ways are added into the program
            	String howD = scanner.next();
            	
            	 if(howD.equals("Ceaser")) {
            		
            		//Asks user the text and offset they want to use to decrypt the ceaser cypher
            		System.out.println("What is the text you would like to decrypt?");
                    String textD = scanner.next();
                    
                    System.out.println("How many characters away is the original message?");
            		String numD = scanner.next();
            				
            		int numDi = Integer.parseInt(numD);
            	
            		int newNumDi = 26-numDi;
            		
            		String decrypted = Encrypter.encode(textD, newNumDi);
                    
            		System.out.println("Here is the Decrypted message with an offset of " + numDi + ": " +  decrypted);
            		
            		System.out.println("please reload the application again if you want to do another calculation");
            		
            	} else if (howD.equals("AlphaNum")){
            		
            		System.out.println("Please enter the numbers WITHOUT THE BRACKETS");
            		String sampleString = scanner.next();
            		
            	      String[] stringArray = sampleString.split(",");
            	      int[] intArray = new int[stringArray.length];
            	      for (int i = 0; i < stringArray.length; i++) {
            	         String numberAsString = stringArray[i];
            	         intArray[i] = Integer.parseInt(numberAsString);
            	      }
            	      System.out.println("Number of letters/integers: " + intArray.length);
            		
            		System.out.println("Please enter the amount you multiplied:");
            		String numS = scanner.next();
            		int num = e.parseD(numS);
            		e.decryptM(intArray, num);
            		
            	}
            	
            	
         }
        //Closes everything that hasn't been previusly closed  to prevent an memory leak
		scanner.close();
        
        	}
        	 
}
