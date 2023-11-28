package main.java;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;

public class GameController {

    private PlantGame game;

    @FXML
    private TextField gessWord;

    @FXML
    private ImageView picture;

    @FXML
    private TextArea charSuggest;

    @FXML
    void initialize() {
       // game = new PlantGame(/* Pass your image URLs here */);
        //loadNextImage();
    }

    @FXML
    void submit(ActionEvent event) {
        String guessedWord = gessWord.getText().trim();
        game.handleGuess(guessedWord);

        if (game.isWordGuessed() || game.isGameOver()) {
            // Display appropriate message or load next image
            loadNextImage();
        }
    }

    @FXML
    void suggest(ActionEvent event) {

    }

    private void loadNextImage() {
        // Logic to load the next image in the ImageView
        // For example:
        //picture.setImage(new Image("path/to/your/image.jpg"));
        // Start a new game
        game.startNewGame();
        gessWord.clear();
        charSuggest.clear();
    }
    public void Continute(javafx.event.ActionEvent actionEvent) {
         game = new PlantGame();
         loadNextImage();
    }

    public void suggest(javafx.event.ActionEvent actionEvent) {
        char suggestedChar = game.suggest();
        charSuggest.appendText(String.valueOf(suggestedChar));
    }

    public void submit(javafx.event.ActionEvent actionEvent) {
    }
}
