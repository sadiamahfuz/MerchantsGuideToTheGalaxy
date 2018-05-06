package main.java;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionSolver {

	private ArrayList<String> intergalacticToRomanNotes;
	private ArrayList<String> materialsCreditsNotes;
	private ArrayList<String> questionsList;
	
	public QuestionSolver() {
		
	}
	
	/**
	 * Constructor extracts notes and questions from input reader.
	 * @param reader (InputFileReader)
	 */
	public QuestionSolver(InputFileReader reader) {
		intergalacticToRomanNotes = reader.getIntergalacticToRomanNotes();
		materialsCreditsNotes = reader.getMaterialCreditNotes();
		questionsList = reader.getQuestionsList();
	}
	
	/**
	 * Returns list of answers.
	 * @return answers (ArrayList<String>)
	 */
	public ArrayList<String> solve() throws IntergalacticNumberException{
		ArrayList<String> answers = new ArrayList<>();
		IntergalacticToRomanDigitMapping intergalacticToRomanDigitMap;
		
		try {
			intergalacticToRomanDigitMap = this.getIntergalacticToRomanMappingFromNotes(intergalacticToRomanNotes);
		} catch(IntergalacticNumberException e) {
			System.err.println(e.getMessage());
			throw e;
		}
		
		HashMap<String, Material> materialsToCreditMap = this.getMaterialsInfo(intergalacticToRomanDigitMap);
		
		// Now answer questions
		// There are two types of questions:
		// 1) How much -> for Intergalactic to Arabic conversion.
		// 2) How many credits -> for solving how many credits for materials required.
		for (String question : questionsList) {
			
			if (question.startsWith("how much is")) {
				// Isolate the intergalatic number string
				String intergalacticString = question.replace("how much is", "");
				intergalacticString = intergalacticString.replace("?", "");
				IntergalacticNumber intergalacticNumber = new IntergalacticNumber(intergalacticString.trim(), intergalacticToRomanDigitMap);
				try {
					int arabicValue = intergalacticNumber.convertToArabic();
					answers.add(intergalacticString.trim() + " is " + arabicValue);
				} catch(IntergalacticNumberException e) {
					answers.add(e.getMessage() + " Please double check your notes");
				}
			}
			
			else if(question.startsWith("how many Credits is")) {
				String restOfQuestion  = question.replace("how many Credits is", "");
				restOfQuestion = restOfQuestion.replace("?", "");
				String[] words = restOfQuestion.split(" ");
				String materialName = words[words.length - 1];
				String intergalacticString = restOfQuestion.replace(materialName, "");
				IntergalacticNumber intergalacticUnitFromQuestion = new IntergalacticNumber(intergalacticString.trim(), intergalacticToRomanDigitMap);
				
				if (materialsToCreditMap.containsKey(materialName)) {
					try {
						Material material = materialsToCreditMap.get(materialName);
						IntergalacticNumber intergalacticUnitFromNote = material.getUnits();
						double creditsPerUnit = (double)material.getCredits() / intergalacticUnitFromNote.convertToArabic();
						double temp = creditsPerUnit * intergalacticUnitFromQuestion.convertToArabic();
						int creditsAnswer = (int)Math.round(temp);
						answers.add(intergalacticString.trim() + " " + materialName + " is " + creditsAnswer + " Credits");
					} catch(IntergalacticNumberException e) {
						answers.add(e.getMessage() + " Please double check your notes!");
					}
				}
				
				else {
					answers.add("I don't have any notes on material " + materialName);
				}
				
			}
			
			else if(question.startsWith("how many")) {
				String[] description = this.getQuestionDescription(question);
				
				if (materialsToCreditMap.containsKey(description[0]) && materialsToCreditMap.containsKey(description[2])) {
					IntergalacticNumber intergalacticUnitFromQuestion = new IntergalacticNumber(description[1], intergalacticToRomanDigitMap);
					double firstCreditPerUnit = materialsToCreditMap.get(description[0]).getCreditsPerUnit();
					double secondCreditPerUnit = materialsToCreditMap.get(description[2]).getCreditsPerUnit();
					int answer = (int)Math.round((double)intergalacticUnitFromQuestion.convertToArabic() * secondCreditPerUnit / firstCreditPerUnit);
					answers.add(description[1] + " " + description[2] + " is " + answer + " " + description[0]);
				}
				else {
					answers.add("Invalid material name(s) " + description[0] + " and " + description[2]);
				}
			}
			
			else {
				answers.add("I have no idea what you are talking about");
			}
		}
		
		return answers;
	}
	
	public String[] getQuestionDescription(String question) {
		
		String restOfQuestion = question.replace("how many", "")
				.replace("?", "").trim();
		String[] tokens = restOfQuestion.split("\\s");
		
		String firstMaterialName = tokens[0];
		String secondMaterialName = tokens[tokens.length-1];
		
		String intergalacticNumber = restOfQuestion.replace(firstMaterialName + " is a ", "")
				.replace(secondMaterialName, "").trim();
	
		
		String[] description =  {firstMaterialName, intergalacticNumber, secondMaterialName};
		return description;
	}
	
	
	private IntergalacticToRomanDigitMapping getIntergalacticToRomanMappingFromNotes(ArrayList<String> intergalacticToRomanNotes) 
			throws IntergalacticNumberException {
		IntergalacticToRomanDigitMapping intergalacticToRomanDigitMap = new IntergalacticToRomanDigitMapping();
		
		//Assumption: each note is three words long and is of the format
		// intergalacticDigit IS RomanDigit
		int intergalacticDigitIndex = 0;
		int romanDigitIndex = 2;
		for (String note : intergalacticToRomanNotes) {
			String[] noteArray = note.split("\\s+");
			intergalacticToRomanDigitMap.addIntergalacticToRomanDigit(noteArray[intergalacticDigitIndex], noteArray[romanDigitIndex]);
		}
		
		return intergalacticToRomanDigitMap;
	}
	
	private HashMap<String, Material> getMaterialsInfo(IntergalacticToRomanDigitMapping intergalacticToRomanDigitMap) {
		HashMap<String, Material> materialsInfo = new HashMap<>();
		
		//Assumption: Each note is of format:
		// intergalacticNumber material IS ArabicNumber CREDITS
		for(String note : materialsCreditsNotes) {
			
			// Get intergalactic number by splitting note by first capital letter
			// which denotes the start of the name of the material
			String unitsString = note.split("[A-Z]{1}")[0];
			IntergalacticNumber units = new IntergalacticNumber(unitsString.trim(), intergalacticToRomanDigitMap);
			
			String restOfLine  = note.replace(unitsString, "");
			String[] words = restOfLine.trim().split("\\s+");
			
			// Material name is at index 0
			// Credit value is at index 2
			String name = words[0];
			int credits = Integer.parseInt(words[2]);
			
			Material material = new Material(name, units, credits);
			materialsInfo.put(name, material);
		}
		
		return materialsInfo;
	}
	
	
}
