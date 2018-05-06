package test.java;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.InputFileReader;

public class InputFileReaderTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testInputFileReaderConstructorWithExistingFile() throws IOException {
		new InputFileReader("inputFiles/sampleInput.txt");
	}
	
	@Test
	public void testInputFileReaderConstructorWithNonExistingFile() throws IOException {
		exception.expect(IOException.class);
		new InputFileReader("inputFiles/doesntExist.txt");
	}
	
	@Test
	public void testGetIntergalacticNumeralsWithFileContainingOnlyValidNotes() throws IOException {
		ArrayList<String> expectedNumeralsValuesList = new ArrayList<String>();
		expectedNumeralsValuesList.add("glob is I");
		expectedNumeralsValuesList.add("prok is V");
		expectedNumeralsValuesList.add("pish is X");
		expectedNumeralsValuesList.add("tegj is L");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleInput.txt");
		assertEquals(expectedNumeralsValuesList, reader.getIntergalacticToRomanNotes());
		
	}
	
	@Test
	public void testGetMaterialCreditsWithFileContainingOnlyValidNotes() throws IOException {
		ArrayList<String> expectedMaterialsCreditList = new ArrayList<String>();
		expectedMaterialsCreditList.add("glob glob Silver is 34 Credits");
		expectedMaterialsCreditList.add("glob prok Gold is 57800 Credits");
		expectedMaterialsCreditList.add("pish pish Iron is 3910 Credits");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleInput.txt");
		assertEquals(expectedMaterialsCreditList, reader.getMaterialCreditNotes());
		
	}
	
	@Test
	public void testGetQuestionsWithFileContainingOnlyValidNotes() throws IOException {
		ArrayList<String> expectedQuestionsList = new ArrayList<String>();
		expectedQuestionsList.add("how much is pish tegj glob glob ?");
		expectedQuestionsList.add("how many Credits is glob prok Silver ?");
		expectedQuestionsList.add("how many Credits is glob prok Gold ?");
		expectedQuestionsList.add("how many Credits is glob prok Iron ?");
		expectedQuestionsList.add("how many Silver is a glob Gold ?");
		expectedQuestionsList.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleInput.txt");
		assertEquals(expectedQuestionsList, reader.getQuestionsList());
		
	}
	@Test
	public void testGetIntergalacticNumeralsWithFileContainingSomeInvalidNotes() throws IOException {
		ArrayList<String> expectedNumeralsValuesList = new ArrayList<String>();
		expectedNumeralsValuesList.add("glob is I");
		expectedNumeralsValuesList.add("prok is V");
		expectedNumeralsValuesList.add("tegj is M");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleWithInvalidData.txt");
		assertEquals(expectedNumeralsValuesList, reader.getIntergalacticToRomanNotes());
		
	}
	
	
	@Test
	public void testGetMaterialCreditsWithFileContainingSomeInvalidNotes() throws IOException {
		ArrayList<String> expectedMaterialsCreditList = new ArrayList<String>();
		expectedMaterialsCreditList.add("glob glob Silver is 34 Credits");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleWithInvalidData.txt");
		assertEquals(expectedMaterialsCreditList, reader.getMaterialCreditNotes());
		
	}
	
	@Test
	public void testGetQuestionsWithFileContainingSomeInvalidNotes() throws IOException {
		ArrayList<String> expectedQuestionsList = new ArrayList<String>();
		expectedQuestionsList.add("how much is pish tegj glob glob ?");
		expectedQuestionsList.add("how many Credits is glob prok Silver ?");
		expectedQuestionsList.add("how Credits is glob prok Gold ?");
		expectedQuestionsList.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		
		InputFileReader reader = new InputFileReader("inputFiles/sampleWithInvalidData.txt");
		assertEquals(expectedQuestionsList, reader.getQuestionsList());
		
	}

}
