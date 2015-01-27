package com.neustar.util;

public class Util {
	
	private static final String GUESS_LARGE_THAN_RANDOM = "Your number is too large!";
	private static final String GUESS_SMALLER_THAN_RANDOM = "Your number is too small!";
	private static final String GUESS_EQUALS_RANDOM = "Congratulations! You guessed the right number";
	
	/**
	 * Compares Guess with Random No.
	 * @param guessNo
	 * @param randomNo
	 * @return
	 */
	public static String compareGuessToRandom(Integer guessNo, Integer randomNo){
		if(guessNo.equals(randomNo)) return GUESS_EQUALS_RANDOM;
		return (guessNo > randomNo) ?  GUESS_LARGE_THAN_RANDOM : GUESS_SMALLER_THAN_RANDOM;
		
	}

}
