package main.java;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.err.println("Input file not provided! Exiting ...");
			System.exit(1);
		}
		
		try {
			InputFileReader reader = new InputFileReader(args[0]);
			QuestionSolver solver = new QuestionSolver(reader);
			ArrayList<String> answers = solver.solve();
			answers.forEach(System.out::println);
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		

	}

}
