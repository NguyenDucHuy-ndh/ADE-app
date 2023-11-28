package main.java;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class AnimalGame extends Game {

    private String[] imageUrls = new String[] {"resources/main/java/Image/animal_Game/dog.png",
            "resources/main/java/Image/animal_Game/elephant.png",
            "resources/main/java/Image/animal_Game/lion.png",
            "resources/main/java/Image/animal_Game/snake.png"};

    public String currentImg ; // đường dẫn đến ảnh hiện tại
    private String[] word = new String[] {"dog", "elephant", "lion", "snake"};
    private String currentWord; // Từ hiện tại đang được đoán
    public String currentGuess; // Kết quả đoán hiện tại (chứa các ký tự đã đoán và các ký tự chưa đoán)
    private int attempts; // Số lần đoán còn lại

    public AnimalGame() {
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