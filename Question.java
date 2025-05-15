import java.util.*;

/**
 * Represents a single quiz question with one correct answer and three wrong answers.
 */
public class Question {
	private String questionText; // The question itself
	private String correctAnswer; // The correct answer
	private ArrayList<String> allAnswers; // A shuffled list containing all answers

	/**
	 * Constructs a Question object.
	 *
	 * @param questionText  the question text
	 * @param correctAnswer the correct answer
	 * @param wrongAnswers  a list of incorrect answers
	 */
	public Question(String questionText, String correctAnswer, ArrayList<String> wrongAnswers) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.allAnswers = new ArrayList<>(wrongAnswers); // Add the wrong answers
		this.allAnswers.add(correctAnswer); // Add the correct answer
		Collections.shuffle(this.allAnswers); // Randomize the answer order
	}


	/**
	 * Returns the question text.
	 * @return the text of the question
	 */
	public String getQuestionText() {
		return questionText;
	}


	/**
	 * Returns the correct answer for this question.
	 * @return the correct answer string
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}


	/**
	 * Returns the list of all possible answers (correct + incorrect), shuffled.
	 * @return list of all answer options
	 */
	public ArrayList<String> getAllAnswers() {
		return allAnswers;
	}
}
