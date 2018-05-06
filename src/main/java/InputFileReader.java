package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.stream.*;

public class InputFileReader {

	private List<String> contentsByLine;
	
	/**
	 * Reads input file and stores each line in an ArrayList if Strings.
	 * Converts content to upper case
	 * @param fileName (String)
	 */
	public InputFileReader(String fileName) throws IOException{
		
		this.contentsByLine = new ArrayList<>();
		
		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			contentsByLine = stream.collect(Collectors.toList());
			stream.close();
		} catch(IOException e) {
			throw e;
		}
	}
	
	/**
	 * Returns list of notes for Intergalactic Number to Roman conversion
	 * These notes have the form numberString<space>IS<space>romanDigit
	 * @return intergacaticToRomanNotes (ArrayList<String>)
	 */
	public ArrayList<String> getIntergalacticToRomanNotes() {
		ArrayList<String> intergacaticToRomanNotes = new ArrayList<String>();
		
		// Assumption: intergalactic numbers are in lower case only, 
		// and roman numerals are in capitals only
		String validNoteRegex = "^[a-z]+\\s+is\\s+[MDCLXVI]$";
		
		for (String line : contentsByLine) {
			
			Pattern notePattern = Pattern.compile(validNoteRegex);
			Matcher match = notePattern.matcher(line);
			
			if (match.find()) {
				intergacaticToRomanNotes.add(line);
			}
		}
	
		return intergacaticToRomanNotes;
	}
	
	/**
	 * Returns list of notes for material credits
	 * @return materialCreditNotes (ArrayList<String>)
	 */
	public ArrayList<String> getMaterialCreditNotes() {
		ArrayList<String> materialCreditNotes = new ArrayList<String>();
		
		// Assumption: These notes follow a well defined structure.
		// I.e. <intergalactic number string> <Material Name> is <Number> Credits
		// Material names are expected to begin with a capital letter
		// The word Credits is also expected to begin with a capital letter
		String validNoteRegex = "^([a-z]+\\s+)*[A-Z]{1}[a-z]*\\s+is\\s+[0-9]+\\s+Credits$";
		
		for (String line : contentsByLine) {
			
			Pattern notePattern = Pattern.compile(validNoteRegex);
			Matcher match = notePattern.matcher(line);
			
			if (match.find()) {
				materialCreditNotes.add(line);
			}
		}
	
		return materialCreditNotes;
	}
	
	/**
	 * Returns list of questions.
	 * Questions end with "?"
	 * @return questionsList (ArrayList<String>)
	 */
	public ArrayList<String> getQuestionsList() {
		ArrayList<String> questionsList = new ArrayList<String>();
				
		for (String line : contentsByLine) {
		
			if (line.endsWith("?")) {
				questionsList.add(line);
			}
		}
		
		return questionsList;
	}
	
}
