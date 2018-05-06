package main.java;

public enum RomanNumeralType {
	I (1),
	V (5),
	X (10),
	L (50),
	C (100),
	D (500),
	M (1000);
	
	private int arabicValue;
	
	RomanNumeralType(int arabicValue) {
		this.arabicValue = arabicValue;
	}
	
	
	/**
	 * Return the arabic representation of the Roman Numeral
	 * @return arabicValue (int)
	 */
	public int getArabicValue(){
		return arabicValue;
	}
	
	/**
	 * Returns the character representation of the Roman Numeral
	 * This is similar to the toString method, except that it returns a char
	 * @return romanDigit (char)
	 */
	public char getCharRepresentation() {
		char romanDigit = 0;
		
		switch(arabicValue) {
			case 1:
				romanDigit = 'I';
				break;
			case 5:
				romanDigit = 'V';
				break;
			case 10:
				romanDigit = 'X';
				break;
			case 50:
				romanDigit = 'L';
				break;
			case 100:
				romanDigit = 'C';
				break;
			case 500:
				romanDigit = 'D';
				break;
			case 1000:
				romanDigit = 'M';
				break;					
		}
		
		return romanDigit;	
	}
	
	/**
	 * Returns the RomanNumeralType represented by the input char
	 * @param romanValue (char)
	 * @return roman (RomanNumeralType)
	 * @throws IllegalArgumentException
	 */
	public static RomanNumeralType getInstance(char romanValue) {
		for (RomanNumeralType roman : values()) {
			if (roman.getCharRepresentation() == romanValue) {
				return roman;
			}
		}
		throw new IllegalArgumentException(romanValue + " is not a Roman Numeral!");
	}
}
