package main.java;

import java.util.Arrays;
import java.util.List;

public class AnimalGame extends Game {
    private List<String> animalImages = Arrays.asList(
            "dog.jpg",
            "cat.jpg",
            "elephant.jpg",
            "lion.jpg"
    );
    public AnimalGame(String[] animalWords) {
        super(animalWords);
    }

    @Override
    public void initialize() {
        // Khởi tạo trò chơi động vật
    }

    @Override
    public void updateWord() {

    }

    @Override
    public void handleGuess(String guessedWord) {
        // Xử lý việc đoán từ trong trò chơi động vật
        String correctWord = words[currentIndex];

        if (guessedWord.equalsIgnoreCase(correctWord)) {
            // Xử lý khi từ đoán đúng
            System.out.println("Đoán đúng!");
        } else {
            // Xử lý khi từ đoán sai
            System.out.println("Đoán sai. Từ đúng là: " + correctWord);
        }

        // Chuyển sang từ tiếp theo
        currentIndex++;

        // Kiểm tra xem đã hoàn thành tất cả các từ chưa
        if (currentIndex < words.length) {
            // Nếu chưa, cập nhật từ mới
            updateWord();
        } else {
            // Nếu đã hoàn thành, hiển thị thông báo hoặc thực hiện các công việc kết thúc trò chơi
            System.out.println("Chúc mừng, bạn đã hoàn thành tất cả các từ!");
        }
    }
}

