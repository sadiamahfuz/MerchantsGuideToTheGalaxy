package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.IntergalacticNumberException;
import main.java.IntergalacticToRomanDigitMapping;

public class IntergalacticToRomanDigitMappingTest {

	private IntergalacticToRomanDigitMapping intergalacticToRomanMap;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		
		intergalacticToRomanMap = new IntergalacticToRomanDigitMapping();
		
		intergalacticToRomanMap.addIntergalacticToRomanDigit("glob", "I");
		intergalacticToRomanMap.addIntergalacticToRomanDigit("pish", "X");
	}


	@Test
	public void testAddExistingIntergalaticNumberFails() throws IntergalacticNumberException{
		exception.expect(IntergalacticNumberException.class);
		exception.expectMessage("glob already has Roman mapping. Cannot add again!");
		intergalacticToRomanMap.addIntergalacticToRomanDigit("glob", "M");
	}
	
	@Test
	public void testGetValidMapping() throws IntergalacticNumberException {
		String romanDigit = intergalacticToRomanMap.getRomanDigitMapping("pish");
		assertEquals("X", romanDigit);
	}
	
	@Test
	public void testGetInvalidMapping() throws IntergalacticNumberException {
		exception.expect(IntergalacticNumberException.class);
		exception.expectMessage("blah does not have a roman mapping!");
		intergalacticToRomanMap.getRomanDigitMapping("blah");
	}

}
