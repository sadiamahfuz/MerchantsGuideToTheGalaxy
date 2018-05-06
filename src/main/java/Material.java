package main.java;

/**
 * Holds information about materials
 * @author mahfuzs
 *
 */
public class Material {
	
	private String name;
	private IntergalacticNumber units;
	private int credits;
	
	/**
	 * Constructor
	 * @param name
	 * @param units
	 * @param credits
	 */
	public Material(String name, IntergalacticNumber units, int credits) {
		this.name = name;
		this.units = units;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public IntergalacticNumber getUnits() {
		return units;
	}

	public int getCredits() {
		return credits;
	}
	
	public double getCreditsPerUnit() throws IntergalacticNumberException {
		return (double)credits / units.convertToArabic();
	}
	
}
