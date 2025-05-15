# JavaFX Quiz Application

A simple multiple-choice quiz system built with JavaFX.  
Loads questions from a text file, displays them with shuffled answers, and gives instant feedback and scoring.

## Features
- Loads questions dynamically from a file  
- Randomizes answer order per question  
- Marks correct and incorrect answers after submission  
- Calculates and displays final score  
- Allows full quiz reset

## How to Run
1. Ensure Java 8 and JavaFX are set up correctly.  
2. Open the project in your IDE.  
3. Make sure `Quiz.fxml` and `questions.txt` are in the correct path.  
4. Run `QuizMain`.

## Files
- `QuizMain.java` – Launches the JavaFX application.  
- `QuizController.java` – Handles UI logic and user interaction.  
- `Question.java` – Represents a single quiz question.  
- `QuestionBank.java` – Loads questions from the file.  
- `QuizTest.java` – Manages the list of questions.  
- `questions.txt` – Plain text file containing all quiz questions.  

## File Format (`questions.txt`)
Each question must be written in 5 lines:  
1. Question text  
2. Correct answer  
3. Wrong answer 1  
4. Wrong answer 2  
5. Wrong answer 3

**Example:**
```
Which planet is known as the Red Planet?
Mars
Venus
Earth
Jupiter
```
