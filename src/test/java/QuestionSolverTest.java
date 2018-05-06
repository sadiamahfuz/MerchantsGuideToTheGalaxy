package test.java;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.InputFileReader;
import main.java.IntergalacticNumberException;
import main.java.QuestionSolver;

public class QuestionSolverTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSolveWithValidData() throws IOException, IntergalacticNumberException {
		InputFileReader reader = new InputFileReader("inputFiles/sampleInput.txt");
		QuestionSolver solver = new QuestionSolver(reader);
		ArrayList<String> answers = solver.solve();
		ArrayList<String> expectedAnswers = new ArrayList<>();
		expectedAnswers.add("pish tegj glob glob is 42");
		expectedAnswers.add("glob prok Silver is 68 Credits");
		expectedAnswers.add("glob prok Gold is 57800 Credits");
		expectedAnswers.add("glob prok Iron is 782 Credits");
		expectedAnswers.add("glob Gold is 850 Silver");
		expectedAnswers.add("I have no idea what you are talking about");
		assertEquals(expectedAnswers, answers);
	}
	
	@Test
	public void testSolveWithInvalidData() throws IOException, IntergalacticNumberException {
		InputFileReader reader = new InputFileReader("inputFiles/sampleWithInvalidData.txt");
		QuestionSolver solver = new QuestionSolver(reader);
		ArrayList<String> answers = solver.solve();
		ArrayList<String> expectedAnswers = new ArrayList<>();
		expectedAnswers.add("pish does not have a roman mapping! Please double check your notes");
		expectedAnswers.add("glob prok Silver is 68 Credits");
		expectedAnswers.add("I have no idea what you are talking about");
		expectedAnswers.add("I have no idea what you are talking about");
		assertEquals(expectedAnswers, answers);
	}

	
	@Test
	public void testGetQuestionDescription() {
		QuestionSolver solver = new QuestionSolver();
		String[] expected = {"Silver", "glob", "Gold"};
		String [] results = solver.getQuestionDescription("how many Silver is a glob Gold ?");
		assertEquals(expected, results);
		
		String[] expected1 = {"Silver", "glob pish", "Gold"};
		String [] results1 = solver.getQuestionDescription("how many Silver is a glob pish Gold ?");
		assertEquals(expected1, results1);
		
		
	}

}
