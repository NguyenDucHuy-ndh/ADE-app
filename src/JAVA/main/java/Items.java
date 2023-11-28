package main.java;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Items extends Game {

    private String[] imageUrls = new String[] {"resources/main/java/Image/Item_Game/air-conditioner.png",
            "resources/main/java/Image/Item_Game/laundry-machine.png",
            "resources/main/java/Image/Item_Game/smart-fridge.png"};

    public String currentImg ; // đường dẫn đến ảnh hiện tại
    private String[] word = new String[] {"air-conditioner", "laundry-machine", "smart-fridge"};
    private String currentWord; // Từ hiện tại đang được đoán
    public String currentGuess; // Kết quả đoán hiện tại (chứa các ký tự đã đoán và các ký tự chưa đoán)
    private int attempts; // Số lần đoán còn lại

    public Items() {
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
    public String getCurentWord() {
        return currentWord;
    }

    @Override
    public void handleGuess(String currentGuess) {
        if (!isGameOver()) {
            if (currentGuess.equalsIgnoreCase(getCurentWord())) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
                attempts--;
                System.out.println("Số lần đoán còn lại: " + getAttempts());
            }
        }

    }

    public boolean isWordGuessed() {
        return currentGuess.equals(currentWord);
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