package main.java;

import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private PlantGame plantGame;
    private PlantGame AnimalGame;
    private PlantGame ItemGame;

    @FXML
    private ImageView picture;

    @FXML
    private TextField guessWord;
    @FXML
    private TextArea charSuggest;


    @FXML
    void continute(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {
        String userGuess = guessWord.getText().trim().toLowerCase();
        String correct = plantGame.getCurentWord().toLowerCase();
        updateUI();

        if (userGuess.equals(correct)) {
            showGameWinAlert();
        } else {
            showGameOverAlert();
        }

    }

    @FXML
    void suggest(ActionEvent event) {
        char suggestedChar = plantGame.suggest();
        charSuggest.appendText(String.valueOf(suggestedChar));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        plantGame = new PlantGame();
        AnimalGame = new PlantGame();
        ItemGame = new PlantGame();
        updateUI();
    }

    private void updateUI() {
        // Cập nhật ImageView và các thành phần khác dựa trên trạng thái của plantGame
        picture.setImage(new Image(plantGame.getCurrentImg()));
        guessWord.clear();
        charSuggest.clear();

    }

    private void showGameOverAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over");
        alert.setContentText("Do you want to start a new game?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            plantGame.startNewGame();
            updateUI();
        } else {
            // Handle the case where the user doesn't want to start a new game
        }
    }
    private void showGameWinAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Win");
        alert.setHeaderText("You Win");

        alert.setContentText("Do you want to start a new game?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
    }

    public void Continute(ActionEvent actionEvent) {
    }


}