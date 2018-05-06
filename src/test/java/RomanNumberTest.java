package test.java;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.RomanNumber;


/**
 * @author mahfuzs
 *
 */
public class RomanNumberTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testRomanNumberIVValid() {
		new RomanNumber("IV");
	}
	
	@Test
	public void testRomanNumberIXValid() {
		new RomanNumber("IX");
	}
	
	@Test
	public void testRomanNumberThreeXValid() {
		new RomanNumber("XXX");
	}
	
	@Test
	public void testRomanNumberThreeIValid() {
		new RomanNumber("III");
	}
	
	@Test
	public void testRomanNumberThreeCValid() {
		new RomanNumber("CCC");
	}
	
	@Test
	public void testRomanNumberThreeMValid() {
		new RomanNumber("MMM");
	}
	
	@Test
	public void testRomanNumberXLVValid() {
		new RomanNumber("XLV");
	}
	
	@Test
	public void testRomanNumberMMCValid() {
		new RomanNumber("MMC");
	}
	
	@Test
	public void testRomanNumberMMCDValid() {
		new RomanNumber("MMCD");
	}
	
	@Test
	public void testRomanNumberFourXWithIValid() {
		new RomanNumber("XXXIX");
	}
	
	@Test
	public void testRomanNumberFourMWithCValid() {
		new RomanNumber("MMMCM");
	}
	
	@Test
	public void testRomanNumberFourXWithLInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("XXXLX");
	}
	
	@Test
	public void testRomanNumberFourIsInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("IIII");
	}
	
	@Test
	public void testRomanNumberFourXsInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("XXXX");
	}
	
	@Test
	public void testRomanNumberFourCsInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("CCCC");
	}
	
	@Test
	public void testRomanNumberFourMsInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("MMMM");
	}
	
	@Test
	public void testRomanNumberTwoDInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("DD");
	}
	
	@Test
	public void testRomanNumberTwoVInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("VIV");
	}

	@Test
	public void testRomanNumberTwoLInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("MLL");
	}
	
	@Test
	public void testRomanNumberILInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("IL");
	}
	
	@Test
	public void testRomanNumberICInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("IC");
	}
	
	@Test
	public void testRomanNumberIDInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("ID");
	}
	
	@Test
	public void testRomanNumberIMInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("IM");
	}
	
	@Test
	public void testRomanNumberXDInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("XD");
	}
	
	@Test
	public void testRomanNumberXMInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("XM");
	}
	
	@Test
	public void testRomanNumberVXInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("VX");
	}
	
	@Test
	public void testRomanNumberVCInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("VC");
	}
	
	@Test
	public void testRomanNumberVDInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("VD");
	}
	
	@Test
	public void testRomanNumberVMInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("VM");
	}
	
	
	@Test
	public void testRomanNumberLCInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("LC");
	}
	
	@Test
	public void testRomanNumberLDInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("LD");
	}
	
	@Test
	public void testRomanNumberLMInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("LM");
	}
	
	@Test
	public void testRomanNumberDMInvalid() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Roman Number!");
		new RomanNumber("DM");
	}
	
	@Test
	public void testConvertToArabicIV() {
		RomanNumber r = new RomanNumber("IV");
		int arabicValue = r.convertToArabic();
		assertEquals(4, arabicValue);
	}
	
	@Test
	public void testConvertToArabicVI() {
		RomanNumber r = new RomanNumber("VI");
		int arabicValue = r.convertToArabic();
		assertEquals(6, arabicValue);
	}
	
	@Test
	public void testConvertToArabicXI() {
		RomanNumber r = new RomanNumber("XI");
		int arabicValue = r.convertToArabic();
		assertEquals(11, arabicValue);
	}
	
	@Test
	public void testConvertToArabicMMVI() {
		RomanNumber r = new RomanNumber("MMVI");
		int arabicValue = r.convertToArabic();
		assertEquals(2006, arabicValue);
	}
	
	@Test
	public void testConvertToArabicXXXIX() {
		RomanNumber r = new RomanNumber("XXXIX");
		int arabicValue = r.convertToArabic();
		assertEquals(39, arabicValue);
	}
	
	@Test
	public void testConvertToArabicCDX() {
		RomanNumber r = new RomanNumber("CDX");
		int arabicValue = r.convertToArabic();
		assertEquals(410, arabicValue);
	}
	
	@Test
	public void testConvertToArabicMCMXLIV() {
		RomanNumber r = new RomanNumber("MCMXLIV");
		int arabicValue = r.convertToArabic();
		assertEquals(1944, arabicValue);
	}
	
	@Test
	public void testConvertToArabicMCMIII() {
		RomanNumber r = new RomanNumber("MCMIII");
		int arabicValue = r.convertToArabic();
		assertEquals(1903, arabicValue);
	}
	
	@Test
	public void testConvertToArabicM() {
		RomanNumber r = new RomanNumber("MDCLXVI");
		int arabicValue = r.convertToArabic();
		assertEquals(1666, arabicValue);
	}
}
