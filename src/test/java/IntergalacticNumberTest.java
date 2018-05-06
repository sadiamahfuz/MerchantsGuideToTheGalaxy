package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.IntergalacticNumber;
import main.java.IntergalacticNumberException;
import main.java.IntergalacticToRomanDigitMapping;

public class IntergalacticNumberTest {

	private IntergalacticNumber validNumber;
	private IntergalacticNumber invalidNumber;
	private IntergalacticToRomanDigitMapping intergalacticToRomanMapping;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		
		intergalacticToRomanMapping = new IntergalacticToRomanDigitMapping();
		
		intergalacticToRomanMapping.addIntergalacticToRomanDigit("glob", "I");
		intergalacticToRomanMapping.addIntergalacticToRomanDigit("prok", "V");
		intergalacticToRomanMapping.addIntergalacticToRomanDigit("pish", "X");
		intergalacticToRomanMapping.addIntergalacticToRomanDigit("tegj", "L");

		
		validNumber = new IntergalacticNumber("pish tegj glob glob", intergalacticToRomanMapping);
		invalidNumber = new IntergalacticNumber("pish tegj glob blah", intergalacticToRomanMapping);
		
	}
	
	
	@Test
	public void testValidConvertToArabic() throws IntergalacticNumberException {
		int arabicValue = validNumber.convertToArabic();
		assertEquals(42, arabicValue);
	}
	
	@Test
	public void testInvalidConvertToArabic() throws IntergalacticNumberException {
		exception.expect(IntergalacticNumberException.class);
		exception.expectMessage("blah does not have a roman mapping!");
		invalidNumber.convertToArabic();
	}

}
