package main.java;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class GuessTheWordController {

    @FXML
    private Label currentWordLabel;

    private static GuessTheWordController instance;

    @FXML
    private TextField guessTextField;

    @FXML
    private Label attemptsLeftLabel;

    @FXML
    private Label resultLabel;

    private String[] words = {"java", "programming", "computer", "algorithm", "developer"};
    private String selectedWord;
    private char[] guessedLetters;
    private int attemptsLeft;

    public void initialize() {
        startNewGame();
    }

    @FXML
    private void guessButtonClicked() {
        if (attemptsLeft > 0) {
            String guess = guessTextField.getText().toLowerCase();
            if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
                char guessedChar = guess.charAt(0);
                if (!hasGuessed(guessedChar)) {
                    updateGuessedLetters(guessedChar);
                    updateUI();

                    if (isWordGuessed()) {
                        resultLabel.setText("Congratulations! You guessed the word!");
                    } else if (attemptsLeft == 0) {
                        resultLabel.setText("Sorry, you ran out of attempts. The word was: " + selectedWord);
                    }
                } else {
                    resultLabel.setText("You already guessed '" + guessedChar + "'. Try a different letter.");
                }
            } else {
                resultLabel.setText("Invalid input. Please enter a single letter.");
            }
        } else {
            resultLabel.setText("The game is over. Start a new game!");
        }
    }

    @FXML
    public void startNewGame() {
        selectedWord = getRandomWord();
        guessedLetters = new char[selectedWord.length()];
        attemptsLeft = 6;

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        updateUI();
        resultLabel.setText("");
    }

    private String getRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    private boolean hasGuessed(char letter) {
        for (char guessedLetter : guessedLetters) {
            if (guessedLetter == letter) {
                return true;
            }
        }
        return false;
    }

    private void updateGuessedLetters(char letter) {
        boolean correctGuess = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter) {
                guessedLetters[i] = letter;
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            attemptsLeft--;
        }
    }

    private boolean isWordGuessed() {
        for (char guessedLetter : guessedLetters) {
            if (guessedLetter == '_') {
                return false;
            }
        }
        return true;
    }

    private void updateUI() {
        currentWordLabel.setText(new String(guessedLetters));
        attemptsLeftLabel.setText(Integer.toString(attemptsLeft));
        guessTextField.clear();
    }
    public static GuessTheWordController getInstance() {
        if (instance == null) {
            instance = new GuessTheWordController();
        }
        return instance;
    }
}

