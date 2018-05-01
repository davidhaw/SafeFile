package base;

import java.util.Random;

public class Ran {

	public int ran() {
		
		int numEi;
		Random rand = new Random();
		numEi = rand.nextInt(24) + 1;
		return numEi;

	}
	
}
