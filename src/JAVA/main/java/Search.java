package main.java;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private BorderPane B_pane;

    @FXML
    private Label meaning;

    @FXML
    private Label description;

    @FXML
    private Label grammarLabel;

    @FXML
    private Label source;

    @FXML
    private TextField searchText;

    @FXML
    private ListView<String> listEnglish;

    private DictionaryDAO dictionaryDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo đối tượng DictionaryDAO với các thông số kết nối
        dictionaryDAO = new DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");

        // Thêm sự kiện khi ấn Enter trong ô tìm kiếm
        searchText.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                search();
            }
        });

        // Thêm sự kiện khi click vào một từ trong ListView
        listEnglish.setOnMouseClicked(event -> {
            String selectedWord = listEnglish.getSelectionModel().getSelectedItem();
            if (selectedWord != null) {
                displayMeaningAndDescription(selectedWord);
            }
        });
    }

    private void search() {
        // Lấy từ khóa tìm kiếm từ ô tìm kiếm
        String _searchWord = searchText.getText().trim();

        // Gọi hàm tìm kiếm từ DictionaryDAO hoặc nơi lưu trữ dữ liệu từ điển
        ObservableList<String> searchResults = dictionaryDAO.searchWord2(_searchWord);

        // Hiển thị kết quả tìm kiếm trong ListView trên luồng giao diện chính
        Platform.runLater(() -> listEnglish.setItems(searchResults));

        // Lấy nghĩa và miêu tả của từ đầu tiên trong kết quả (nếu có) trên luồng giao diện chính
        if (!searchResults.isEmpty()) {
            String firstWord = searchResults.get(0);
            Platform.runLater(() -> displayMeaningAndDescription(firstWord));
        } else {
            // Nếu không có kết quả, xóa nghĩa và miêu tả trên luồng giao diện chính
            Platform.runLater(() -> {
                meaning.setText("");
                description.setText("");
            });
        }
    }

    private void displayMeaningAndDescription(String word) {
        String[] wordInfo = dictionaryDAO.getWordInfo(word);

        // Hiển thị nghĩa và miêu tả trên luồng giao diện chính
        Platform.runLater(() -> {
            source.setText(wordInfo[0]);
            meaning.setText(wordInfo[2]);
            description.setText(wordInfo[1]);
        });
    }

    @FXML
    void speak(ActionEvent event) {
        String speakWord = source.getText().trim();
        TextToSpeech tts = new TextToSpeech();
        tts.speak(speakWord, "en", 0.75);
    }

}
