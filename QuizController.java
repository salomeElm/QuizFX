import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * Controller for managing the quiz logic and UI interaction.
 */
public class QuizController {

	@FXML
	private GridPane grid; // Layout for displaying questions and answers

	private QuizTest quiz;
	private Map<Question, ToggleGroup> questionToGroup = new HashMap<>(); // Maps each question to its group of radio buttons


	/**
	 * Initializes the controller by loading questions and building the quiz interface.
	 */
	public void initialize() throws IOException {
		QuestionBank bank = new QuestionBank("questions.txt");
		quiz = new QuizTest(bank.getQuestions());
		buildQuiz();
	}

	/**
	 * Builds the quiz UI by adding labels and radio buttons to the grid.
	 */ 
	private void buildQuiz() {
		grid.getChildren().clear(); // Clear previous content
		questionToGroup.clear(); // Reset question-to-toggle mapping

		int row = 0;
		for (Question q : quiz.getQuestions()) {
			Label label = new Label(q.getQuestionText()); // Create a label for the question
			grid.add(label, 0, row); // Add question to the grid
			row++;

			ToggleGroup group = new ToggleGroup(); // Group to allow only one answer selection per question
			for (String answer : q.getAllAnswers()) {
				RadioButton rb = new RadioButton(answer); // Create a radio button for each answer
				rb.setToggleGroup(group);
				grid.add(rb, 0, row); // Add answer to the grid
				row++;
			}
			questionToGroup.put(q, group); // Map the question to its toggle group
		}
	}


	/**
	 * Triggered when the "Finish" button is pressed.
	 * Checks answers, marks them with v or x, disables further editing, and shows the score.
	 */
	@FXML
	void finishPressed(ActionEvent event) {
		int correctCount = 0;

		for(Question q : quiz.getQuestions()) {
			ToggleGroup group = questionToGroup.get(q); // Get toggle group for the current question
			RadioButton selected = (RadioButton)group.getSelectedToggle(); // Get selected answer
			if(selected != null) {
				if(selected.getText().equals(q.getCorrectAnswer())) {
					selected.setText(selected.getText() + " \u2714"); // Add check mark for correct answer. v = " \u2714".
					correctCount++;
				}
				else {
					selected.setText(selected.getText() + " \u2716"); // Add X mark for incorrect answer. x = " \u2716".
				}
			}

			// Disable all radio buttons after finishing
			for (Toggle toggle : group.getToggles()) {
				RadioButton rb = (RadioButton) toggle;
				rb.setDisable(true); 
			}
		}

		double score = 100.0 * correctCount / quiz.getQuestions().size();
		JOptionPane.showMessageDialog(null, "Your score is: " + String.format("%.2f", score) + "%");
	}


	/**
	 * Triggered when the "Reset" button is pressed.
	 * Clears all answers, removes check/X marks, and enables all radio buttons again.
	 */
	@FXML
	void resetPressed(ActionEvent event) {
		for (Question q : quiz.getQuestions()) {
			ToggleGroup group = questionToGroup.get(q);

			for (Toggle toggle : group.getToggles()) {
				RadioButton rb = (RadioButton) toggle;

				// Remove check/X marks from text
				String text = rb.getText();
				text = text.replace(" \u2714", "").replace(" \u2716", "");  // מסירה את הוי והאיקס
				rb.setText(text);
				
				rb.setSelected(false);  // Unselect
				rb.setDisable(false); // Enable again
			}
		}
	}

}

