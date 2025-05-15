import java.io.*;
import java.util.*;

/**
 * Responsible for loading quiz questions from a text file.
 */
public class QuestionBank {
	private ArrayList<Question> questions = new ArrayList<>(); //A list of all the questions.

	/**
	 * Constructs a QuestionBank and loads questions from the specified file.
	 *
	 * @param fileName the name of the text file containing the questions
	 * @throws IOException if file format is incorrect or cannot be read
	 */
	public QuestionBank(String fileName) throws IOException {
		loadFromFile(fileName); // Load questions from file when the object is created
	}

	/**
	 * Loads questions from a text file. Each question must be represented in 5 lines:
	 * question, correct answer, and 3 wrong answers.
	 *
	 * @param fileName the name of the text file
	 * @throws IOException if the format is incorrect or missing data
	 */
	private void loadFromFile(String fileName) throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;

			// Read questions in blocks of 5 lines until reaching the end of the file
			while ((line = reader.readLine()) != null) { 
				String questionText = line; // First line: question text
				checkIfLineIsEmpty(questionText);
				String correct = reader.readLine(); // Second line: correct answer
				checkIfLineIsEmpty(correct);
				ArrayList<String> wrongs = new ArrayList<>();
				// Next three lines: incorrect answers
				for (int i = 0; i < 3; i++) {  
					String wrongAns = reader.readLine();
					checkIfLineIsEmpty(wrongAns);
					wrongs.add(wrongAns);
				}

				// Create a Question object and add it to the list
				questions.add(new Question(questionText, correct, wrongs)); 
			}
		}
	}

	/**
	 * Validates that a line is not empty or whitespace only.
	 *
	 * @param line the line to validate
	 * @throws IOException if the line is empty or null
	 */
	private void checkIfLineIsEmpty(String line) throws IOException{
		if (line == null || line.trim().isEmpty()) {
			throw new IOException("File error: A line is empty. Question or answers may be missing.");
		}
	}


	/**
	 * Returns the list of questions loaded from the file.
	 * @return list of Question objects
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
