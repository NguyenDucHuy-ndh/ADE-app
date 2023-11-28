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

    private String[] imageUrls = new String[] {"Image/Palnt_Game/sunflower.png",
            "Image/Palnt_Game/pumpkin.png",
            "Image/Palnt_Game/cactus.png",};

    @FXML
    void initialize() {
        game = new PlantGame(imageUrls);
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

    public String[] getImageUrls() {
        return imageUrls;
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
         game = new PlantGame( imageUrls);
         loadNextImage();
    }

    public void suggest(javafx.event.ActionEvent actionEvent) {
        char suggestedChar = game.suggest();
        charSuggest.appendText(String.valueOf(suggestedChar));
    }

    public void submit(javafx.event.ActionEvent actionEvent) {

        String guessedWord = gessWord.getText().trim();
        game.handleGuess(guessedWord);

    }
}
