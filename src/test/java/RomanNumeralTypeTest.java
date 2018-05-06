/**
 * 
 */
package test.java;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.RomanNumeralType;

/**
 * @author mahfuzs
 *
 */
public class RomanNumeralTypeTest {

	/**
	 * 	NB: There are multiple assert statements in test cases
	 *  within this file.
	 *  Although this is generally bad practice, it has been used
	 *  in this instance to contain the testing of one idea within 
	 *  a single test case.
	 */
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testGetCharRepresentation() {
		RomanNumeralType roman = RomanNumeralType.I;
		char romanChar = roman.getCharRepresentation();
		assertEquals('I', romanChar);
		
		roman = RomanNumeralType.V;
		romanChar = roman.getCharRepresentation();
		assertEquals('V', romanChar);
		
		roman = RomanNumeralType.X;
		romanChar = roman.getCharRepresentation();
		assertEquals('X', romanChar);
		
		roman = RomanNumeralType.L;
		romanChar = roman.getCharRepresentation();
		assertEquals('L', romanChar);
		
		roman = RomanNumeralType.C;
		romanChar = roman.getCharRepresentation();
		assertEquals('C', romanChar);
		
		roman = RomanNumeralType.D;
		romanChar = roman.getCharRepresentation();
		assertEquals('D', romanChar);
		
		roman = RomanNumeralType.M;
		romanChar = roman.getCharRepresentation();
		assertEquals('M', romanChar);
	}
	
	@Test
	public void testGetInstance() {
		RomanNumeralType roman = RomanNumeralType.getInstance('I');
		assertEquals(RomanNumeralType.I, roman);
		
		roman = RomanNumeralType.getInstance('V');
		assertEquals(RomanNumeralType.V, roman);
		
		roman = RomanNumeralType.getInstance('X');
		assertEquals(RomanNumeralType.X, roman);
		
		roman = RomanNumeralType.getInstance('L');
		assertEquals(RomanNumeralType.L, roman);
		
		roman = RomanNumeralType.getInstance('C');
		assertEquals(RomanNumeralType.C, roman);
		
		roman = RomanNumeralType.getInstance('D');
		assertEquals(RomanNumeralType.D, roman);
		
		roman = RomanNumeralType.getInstance('M');
		assertEquals(RomanNumeralType.M, roman);		
	}
	
	@Test
	public void testGetArabicValue() {
		RomanNumeralType roman = RomanNumeralType.getInstance('I');
		int arabicValue = roman.getArabicValue();
		assertEquals(1, arabicValue);
		
		roman = RomanNumeralType.getInstance('V');
		arabicValue = roman.getArabicValue();
		assertEquals(5, arabicValue);
		
		roman = RomanNumeralType.getInstance('X');
		arabicValue = roman.getArabicValue();
		assertEquals(10, arabicValue);
		
		roman = RomanNumeralType.getInstance('L');
		arabicValue = roman.getArabicValue();
		assertEquals(50, arabicValue);
		
		roman = RomanNumeralType.getInstance('C');
		arabicValue = roman.getArabicValue();
		assertEquals(100, arabicValue);
		
		roman = RomanNumeralType.getInstance('D');
		arabicValue = roman.getArabicValue();
		assertEquals(500, arabicValue);
		
		roman = RomanNumeralType.getInstance('M');
		arabicValue = roman.getArabicValue();
		assertEquals(1000, arabicValue);
	}
	
	@Test
	public void testGetInstanceThrowsIllegalArgumentExceptionWhenInvalidArgument() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Y is not a Roman Numeral!");
		RomanNumeralType.getInstance('Y');
	}
	

}
