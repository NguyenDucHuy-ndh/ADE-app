package main.java;

import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public abstract class Game {
<<<<<<< HEAD
=======
    @FXML
    private ImageView imageView;



    @FXML
    private TextField guessField;

    private String currentWord;
    private String currentImage;
    protected String[] words; // Danh sách từ cần đoán
    protected int currentIndex; // Chỉ số hiện tại của từ đang được đoán

    public Game(String[] words) {
        this.words = words;
        this.currentIndex = 0;
    }
>>>>>>> 406faee9322ed5ab31f8e978e9669a0917d3f060

    // Phương thức trừu tượng để khởi tạo trò chơi
    public abstract void initialize();

    // Phương thức trừu tượng để cập nhật từ đang được đoán
    public abstract String getCurentWord();

    // Phương thức trừu tượng để xử lý việc đoán từ
    public abstract void handleGuess(String guessedWord);



//    public void handleStart() {
//        // Xử lý khi nút "Start" được nhấn
//        // Load ảnh và từ mới
//        currentImage = "path/to/your/image.jpg";
//        currentWord = "apple"; // Từ cần đoán
//        imageView.setImage(new Image(currentImage));
//        guessField.clear();
//    }


    public void handleGuess() {
        // Xử lý khi nút "Guess" được nhấn
        String guessedWord = guessField.getText();
        if (guessedWord.equalsIgnoreCase(currentWord)) {
            // Đoán đúng, chuyển đến hình ảnh tiếp theo
            //handleStart();
        } else {
            // Đoán sai, xử lý theo ý của bạn (ví dụ: giảm số lần đoán)
        }
    }


}
