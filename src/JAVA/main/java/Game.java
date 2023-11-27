package main.java;

public abstract class Game {

    // Phương thức trừu tượng để khởi tạo trò chơi
    public abstract void initialize();

    // Phương thức trừu tượng để cập nhật từ đang được đoán
    public abstract String getCurentWord();

    // Phương thức trừu tượng để xử lý việc đoán từ
    public abstract void handleGuess(String guessedWord);
}
