package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.List;
<<<<<<< HEAD
/*
public class AnimalGame extends Game implements PictureWord {
=======

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

>>>>>>> 406faee9322ed5ab31f8e978e9669a0917d3f060
    private List<String> animalImages = Arrays.asList(
            "dog.jpg",
            "cat.jpg",
            "elephant.jpg",
            "lion.jpg"
    );
<<<<<<< HEAD
    /*
    private String currentWord; // Từ hiện tại đang được đoán
    private String currentGuess; // Kết quả đoán hiện tại (chứa các ký tự đã đoán và các ký tự chưa đoán)
    private int attempts; // Số lần đoán còn lại


    public AnimalGame(String[] animalWords) {
=======

    public AnimalGame(String[] animalWords, ImageView imageView, TextField guessField) {
>>>>>>> 406faee9322ed5ab31f8e978e9669a0917d3f060
        super(animalWords);
        this.imageView = imageView;
        this.guessField = guessField;
    }

    @Override
    public void initialize() {
<<<<<<< HEAD

=======
        // Khởi tạo trò chơi động vật
        currentWord = "lion"; // Từ cần đoán
        guessField.clear();
>>>>>>> 406faee9322ed5ab31f8e978e9669a0917d3f060
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

<<<<<<< HEAD
    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getImageUrls() {
        return null;
    }

    @Override
    public boolean checkGuess(String guess) {
        return false;
    }*/
//}

=======


}
>>>>>>> 406faee9322ed5ab31f8e978e9669a0917d3f060

