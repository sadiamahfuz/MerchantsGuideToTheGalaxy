package main.java;

import java.util.HashMap;

public class IntergalacticNumber {

	private String interglacticString;
	private IntergalacticToRomanDigitMapping intergalacticToRomanMap;
	
	/**
	 * Intergalactic Number Constructor 
	 * @param interglacticString a space separated string, which each word representing one digit
	 * @param intergalacticToRomanMap intergalactic digit to roman digit mappings
	 */
	public IntergalacticNumber(String interglacticString, IntergalacticToRomanDigitMapping intergalacticToRomanMap) {
		this.interglacticString = interglacticString;
		this.intergalacticToRomanMap = intergalacticToRomanMap;
	}
	
	/**
	 * Return Arabic value of this Intergalactic Number
	 * @return arabic value (int)
	 * @throws IntergalacticNumberException
	 */
	public int convertToArabic() throws IntergalacticNumberException {
		String romanString = this.convertToRoman();
		RomanNumber romanNumber = new RomanNumber(romanString);
		return romanNumber.convertToArabic();
	}
	
	/**
	 * Return Roman number representation of this Intergalactic Number 
	 * @return romanString
	 * @throws IntergalacticNumberException
	 */
	private String convertToRoman() throws IntergalacticNumberException	{
		String[] digits = interglacticString.split(" ");
		String romanString = "";
		
		for (String digit : digits) {
			String romanDigit = intergalacticToRomanMap.getRomanDigitMapping(digit);
			romanString += romanDigit;
		}
		
		return romanString;
	}
}
