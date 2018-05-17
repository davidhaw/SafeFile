

import java.io.*;
import java.lang.*;
import java.util.*;


public class createfile {

	private Formatter x;
	
	public void openFile() {
		try{
			x = new Formatter("textE.txt");
		} catch(Exception e) {
			System.out.println("Error with writting to file");
		}
	}
		public void addRecords(String en) {
			x.format("%s", en);
			
		}
		
		public void closeFile() {
			x.close();
		}
		
}
	

