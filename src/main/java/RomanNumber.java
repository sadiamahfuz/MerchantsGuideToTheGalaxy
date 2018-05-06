/**
 * 
 */
package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author mahfuzs
 *
 */
public class RomanNumber {
	
	private String romanString;
	
	/**
	 * Constructs a RomanNumber
	 * @param romanString String representation of Roman Number
	 * @throws IllegalArgumentException
	 */
	public RomanNumber(String romanString) {
		this.romanString = romanString;
		
		// Ensure that the input Roman String is valid.
		if (!isValidRomanString()) {
			throw new IllegalArgumentException("Invalid Roman Number!");
		}
	}
	
	
	/**
	 * Returns the Arabic (decimal) value of the Roman Number.
	 * @return arabicValue (int)
	 */
	public int convertToArabic() {
		int arabicValue = 0;
		
		int numRomanDigits = romanString.length();
		int[] arabicValues = new int[numRomanDigits];
		
		RomanNumeralType currentRoman = null;
		
		// Get the integer value of each Roman Digit and store in array
		for (int i = 0; i < numRomanDigits; i++) {
			currentRoman = RomanNumeralType.getInstance(romanString.charAt(i));
			arabicValues[i] = currentRoman.getArabicValue();
			
			//  Negate numbers which are immediately followed by a larger number
			if (i > 0 && arabicValues[i-1] < arabicValues[i]) {
				arabicValues[i-1] = -1 * arabicValues[i-1];
			}
		}
		
		// Get sum of integer array to get final result
		arabicValue = IntStream.of(arabicValues).sum();
		return arabicValue;
	}
	
	/**
	 * Determines whether romanString represents a valid Roman Number.
	 * 
	 * Rules:
	 * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
	 * They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) 
	 * "D", "L", and "V" can never be repeated.
	 * "I" can be subtracted from "V" and "X" only. 
	 * "X" can be subtracted from "L" and "C" only. 
	 * "C" can be subtracted from "D" and "M" only. 
	 * "V", "L", and "D" can never be subtracted.
	 * 
	 * @return isValid (boolean)
	 */
	private boolean isValidRomanString() {
		boolean isValid = true;
		
		String validRomanRegexString = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
		
		Pattern validRomanRegex = Pattern.compile(validRomanRegexString);
		Matcher match = validRomanRegex.matcher(romanString);
		
		isValid = match.find();
		
		return isValid;
	}
}
