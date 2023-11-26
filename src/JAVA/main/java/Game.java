package main.java;

public abstract class Game {
    protected String[] words; // Danh sách từ cần đoán
    protected int currentIndex; // Chỉ số hiện tại của từ đang được đoán

    public Game(String[] words) {
        this.words = words;
        this.currentIndex = 0;
    }

    // Phương thức trừu tượng để khởi tạo trò chơi
    public abstract void initialize();

    // Phương thức trừu tượng để cập nhật từ đang được đoán
    public abstract void updateWord();

    // Phương thức trừu tượng để xử lý việc đoán từ
    public abstract void handleGuess(String guessedWord);
}
