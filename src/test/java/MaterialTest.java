package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.IntergalacticNumber;
import main.java.IntergalacticNumberException;
import main.java.IntergalacticToRomanDigitMapping;
import main.java.Material;

public class MaterialTest {

	private Material m;
	@Before
	public void setUp() throws Exception {
		String name = "Platinum";
		IntergalacticToRomanDigitMapping map = new IntergalacticToRomanDigitMapping();
		map.addIntergalacticToRomanDigit("glob", "I");
		map.addIntergalacticToRomanDigit("prok", "V");
		IntergalacticNumber units = new IntergalacticNumber("glob prok", map);
		int credits = 100;
		m = new Material(name, units, credits);
		
	}

	@Test
	public void testGetName() {
		assertEquals("Platinum", m.getName());
	}

	@Test
	public void testGetUnits() throws IntergalacticNumberException {
		assertEquals(4, m.getUnits().convertToArabic());
	}

	@Test
	public void testGetCredits() {
		assertEquals(100, m.getCredits());
	}
	
	@Test
	public void testGetCreditsPerUnit() throws IntergalacticNumberException {
		assertEquals(25.0, m.getCreditsPerUnit(), 0.0);
	}
	
	@Test 
	public void testGetCreditsForGold() throws IntergalacticNumberException{
		IntergalacticToRomanDigitMapping map = new IntergalacticToRomanDigitMapping();
		map.addIntergalacticToRomanDigit("pish", "X");
		map.addIntergalacticToRomanDigit("prok", "V");
		IntergalacticNumber units = new IntergalacticNumber("pish prok", map);
		String name = "gold";
		int credits = 1500;
		Material gold = new Material(name, units, credits);
		assertEquals(100.0, gold.getCreditsPerUnit(), 0.0);
	}

}
