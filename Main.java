package base;
import java.util.Scanner;
import java.util.Random;

public class Main {
	
	
    public static void main(String[] args) {

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
    	System.out.println("How Would You Like to Encrypt? - Available Currently: Ceaser Cypher");
    	System.out.println("For Ceaser Cypher, enter Ceaser"); //More would be added in as more encryption ways are added into the program
    	
    	String howE = scanner.next();
    	
    	if (howE.equals("Ceaser")) {
    		
            System.out.println("What is the text you would like to encrypt?");
            String textE = scanner1.next();
            
            System.out.println("What is the offset for the Ceaser Cypher?");
    		String numE = scanner1.next();
    				
    		int numEi = Integer.parseInt(numE);
    	
    		String encrypted = Encrypter.encode(textE, numEi);
            
    		System.out.println("Below is encrypted Text with Ceaser Cypher, offset of " + numE);
    		System.out.println(encrypted);
    		
            // close the scanner
            scanner1.close();
            
                scanner.close();
        		
        	}
        } else if (EorD.equals("Decrypt")){
        		
        		System.out.println("Decrypting message");
        	
        		//Asks the user how they want to decrypt
            	System.out.println("How Would You Like to Decrypt? - Available Currently: Ceaser Cypher");
            	System.out.println("For Ceaser Cypher, enter Ceaser"); //More would be added in as more encryption ways are added into the program
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
                    
            		System.out.println(decrypted);
            		
            		System.out.println("please close and open the application again if you want to do another calculation");
            		
            		
            	}
            	
            	
         }
        	}
        	 
}