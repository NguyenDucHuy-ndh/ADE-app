package main.java;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class PlantGame extends Game {
    private String[] imageUrls = new String[] {"Image/Palnt_Game/sunflower.png",
            "Image/Palnt_Game/pumpkin.png",
            "Image/Palnt_Game/cactus.png",};
    private String currentImg; // đường dẫn đến ảnh hiện tại
    private String[] word = new String[] {"sunflower", "pumpkin", "cactus"};
    private String currentWord; // Từ hiện tại đang được đoán
    public String currentGuess; // Kết quả đoán hiện tại (chứa các ký tự đã đoán và các ký tự chưa đoán)
    private int attempts; // Số lần đoán còn lại

    public PlantGame(String[] imageUrls) {
        this.imageUrls = imageUrls;
        startNewGame();
    }
    public void startNewGame() {
        Random random = new Random();
        int r = random.nextInt(3);
        currentImg = imageUrls[r];
        currentWord = word[r];

        attempts = 5; // Số lần đoán tối đa
    }

    public char suggest() {
        return currentWord.charAt(0);
    }

    @Override
    public void initialize() {

    }

    @Override
    public String getCurentWord() {
        return currentWord;
    }

    @Override
<<<<<<< HEAD
    public void handleGuess(String currentGuess) {

        //Scanner sc = new Scanner(System.in);
        //currentGuess = sc.nextLine();
=======
    public void handleGuess() {
        Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
        currentGuess = sc.nextLine();
=======
        String guessedWord = sc.nextLine();
>>>>>>> 4f41f170831f01e0f836567b4a99974a1082e0db
>>>>>>> 88bae5ab2d8a739fefc4588f8a2e20aa255651e9
        if (!isGameOver()) {
            if (currentGuess.equalsIgnoreCase(getCurentWord())) {
                System.out.println("Corect");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Plant");
                alert.setHeaderText("Corect, congratulations!");
                //ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                //ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
                //alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
                Optional<ButtonType> result = alert.showAndWait();

            } else {
                System.out.println("Wrong");
                attempts--;
                System.out.println("Số lần đoán còn lại: " + getAttempts());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Plant");
                alert.setHeaderText("incorect, falied!"+getAttempts());
            }
        }


    }
    public boolean isWordGuessed() {
        return currentGuess.toString().equals(currentWord);
    }
    public boolean isGameOver() {
        return attempts == 0 || isWordGuessed();
    }

    public int getAttempts() {
        return attempts;
    }

    public String getCurrentImg() {
        return currentImg;
    }

    public String getCurrentWord() {
        return currentWord;
    }

}


