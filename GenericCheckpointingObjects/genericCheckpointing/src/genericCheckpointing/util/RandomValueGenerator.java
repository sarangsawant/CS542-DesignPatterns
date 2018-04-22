package genericCheckpointing.util;

import java.util.Random;

public class RandomValueGenerator {
	
	/**
	 * Generates random value between 0 and 20
	 * @return
	 */
	public int getInt() {
		Random r = new Random();
		return r.nextInt((20 - 0) + 1) + 0;
	}
	
	public double getDouble() {
		Random r = new Random();
		return r.nextDouble() * 1 + (20 - 1) ;
	}
	
	public float getFloat() {
		Random r = new Random();
		return r.nextFloat() * 1 + (20 - 1) ;
	}
	
	
	public boolean getBool() {
		Random r = new Random();
		return r.nextBoolean();
	}
	
	public char getChar() {
		Random r = new Random();

	    String alphabets = "abcdefghijklmnopqrsuvwxyz";
        return alphabets.charAt(r.nextInt(alphabets.length()));
	}
}
