package base;

import java.io.*;

public class Read {
    public static String read(String hi) {

        // The name of the file to open.
        String fileName = "textE.txt";
        String text;
        // This will reference one line at a time

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

             String values = bufferedReader.readLine();
             hi = values;
             
            // Always close files.
            bufferedReader.close();  

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        } finally {
        	return hi;
        }
        
    }
}

