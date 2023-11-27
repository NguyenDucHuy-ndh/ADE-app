package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.List;

public class AnimalGame extends Game {

    @FXML
    private ImageView imageView;

    @FXML
    private TextField guessField;

    private String currentWord;
    private String currentImage;

    public void handleStart() {
        // Xử lý khi nút "Start" được nhấn
        // Load ảnh và từ mới
//        currentImage = "path/to/your/image.jpg";
//        currentWord = "apple"; // Từ cần đoán
//        imageView.setImage(new Image(currentImage));
//        guessField.clear();
    }




    public void handleGuess() {
        // Xử lý khi nút "Guess" được nhấn
        String guessedWord = guessField.getText();
        if (guessedWord.equalsIgnoreCase(currentWord)) {
            // Đoán đúng, chuyển đến hình ảnh tiếp theo
            handleStart();
        } else {
            // Đoán sai, xử lý theo ý của bạn (ví dụ: giảm số lần đoán)
        }
    }

    private List<String> animalImages = Arrays.asList(
            "dog.jpg",
            "cat.jpg",
            "elephant.jpg",
            "lion.jpg"
    );

    public AnimalGame(String[] animalWords, ImageView imageView, TextField guessField) {
        super(animalWords);
        this.imageView = imageView;
        this.guessField = guessField;
    }

    @Override
    public void initialize() {
        // Khởi tạo trò chơi động vật
        currentWord = "lion"; // Từ cần đoán
        guessField.clear();
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

