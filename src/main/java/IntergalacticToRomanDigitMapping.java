package main.java;

import java.util.HashMap;

public class IntergalacticToRomanDigitMapping {

	private HashMap<String, String> intergalacticToRomanDigitMap;
	
	/**
	 * Empty Constructor. Initialises empty map.
	 */
	public IntergalacticToRomanDigitMapping() {
		intergalacticToRomanDigitMap = new HashMap<>();
	}
	
	/**
	 * Constructor that provides a map of intergalactic -> roman digits.
	 * @param mappings
	 */
	public IntergalacticToRomanDigitMapping(HashMap<String, String> mappings) {
		intergalacticToRomanDigitMap = mappings;
	}
	
	/**
	 * Adds a intergalactic -> Roman Digit mapping
	 * @param intergalacticDigit
	 * @param romanDigit
	 * @throws IntergalacticNumberException
	 */
	public void addIntergalacticToRomanDigit(String intergalacticDigit, String romanDigit) 
			throws IntergalacticNumberException {
		if (!intergalacticToRomanDigitMap.containsKey(intergalacticDigit)) {
			intergalacticToRomanDigitMap.put(intergalacticDigit, romanDigit);
		}
		else {
			throw new IntergalacticNumberException(intergalacticDigit + " already has Roman mapping. Cannot add again!");
		}
	}
	
	/**
	 * Returns the Roman digit representation of the input intergalactic digit if mapping exists.
	 * @param intergalacticDigit
	 * @return romanDigit
	 * @throws IntergalacticNumberException
	 */
	public String getRomanDigitMapping(String intergalacticDigit) 
			throws IntergalacticNumberException {
		if (intergalacticToRomanDigitMap.containsKey(intergalacticDigit)) {
			return intergalacticToRomanDigitMap.get(intergalacticDigit);
		}
		else {
			throw new IntergalacticNumberException(intergalacticDigit + " does not have a roman mapping!");
		}
	}
}
