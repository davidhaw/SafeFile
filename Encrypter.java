package base;

// Encrypts the data using ceaser cypher. This will have to be updated to PGP later down the road for better encryption. 
// The encryption code is from https://rosettacode.org/wiki/Caesar_cipher#Java
public class Encrypter {

	 public static String decode(String enc, int offset) {
	        return encode(enc, 26-offset);
	    }
	 
	    public static String encode(String enc, int offset) {
	        offset = offset % 26 + 26;
	        StringBuilder encoded = new StringBuilder();
	        for (char i : enc.toCharArray()) {
	            if (Character.isLetter(i)) {
	                if (Character.isUpperCase(i)) {
	                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
	                } else {
	                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
	                }
	            } else {
	                encoded.append(i);
	            }
	        }
	        return encoded.toString();
	    }
	
}
