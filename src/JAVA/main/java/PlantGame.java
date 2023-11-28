package main.java;

import java.util.Random;
import java.util.Scanner;

public class PlantGame extends Game {
    private String[] imageUrls = new String[] {"Image/Palnt_Game/sunflower.png",
            "Image/Palnt_Game/pumpkin.png",
            "Image/Palnt_Game/cactus.png",};
    private String currentImg; // đường dẫn đến ảnh hiện tại
    private String[] word = new String[] {"sunflower", "pumpkin", "cactus"};
    private String currentWord; // Từ hiện tại đang được đoán
    private String currentGuess; // Kết quả đoán hiện tại (chứa các ký tự đã đoán và các ký tự chưa đoán)
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
    public void handleGuess(String guessedWord) {

        Scanner sc = new Scanner(System.in);
        guessedWord = sc.nextLine();
        if (!isGameOver()) {
            if (guessedWord.equalsIgnoreCase(getCurentWord())) {
                System.out.println("Corect");
            } else {
                System.out.println("Wrong");
                attempts--;
                System.out.println("Số lần đoán còn lại: " + getAttempts());
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


