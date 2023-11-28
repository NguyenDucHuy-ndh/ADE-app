package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private PlantGame plantGame;

    @FXML
    private ImageView picture;

    @FXML
    private TextField guessWord;
    @FXML
    private TextArea charSuggest;


    @FXML
    void continute(ActionEvent event) {
        plantGame.startNewGame();
        updateUI();
    }

    @FXML
    void submit(ActionEvent event) {
        String userGuess = guessWord.getText().trim().toLowerCase();
        String correct = plantGame.getCurentWord().toLowerCase();

        boolean containsSubstring = correct.contains(userGuess);

        updateUI();

        if (containsSubstring) {
            System.out.println("true");
            showGameWinAlert();
        } else {
            System.out.println("false");
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

    }
    private void showGameWinAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Win");
        alert.setHeaderText("You Win");
        alert.setContentText("Do you want to start a new game?");

        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonTypeYes) {
            // Người dùng chọn "Yes", thực hiện logic bắt đầu trò chơi mới ở đây
            plantGame.startNewGame();
            // Sau đó, cập nhật giao diện người dùng với trạng thái mới
            updateUI();
        } else {
            updateUI();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Thank you");
            a.setHeaderText("Thank you");
            a.showAndWait();
        }
    }
}
