import java.util.ArrayList;

/**
 * Represents a quiz composed of a list of questions.
 */
public class QuizTest {
	private ArrayList<Question> questions;

	/**
	 * Constructs a QuizTest with a given list of questions.
	 *
	 * @param questions the list of questions in the quiz
	 */
	public QuizTest(ArrayList<Question> questions) {
		this.questions = questions;
	}


	/**
	 * Returns the list of questions.
	 * @return list of questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
}
