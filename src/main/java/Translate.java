package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Translate {

    @FXML
    private TextField vanBan;

    @FXML
    private Label banDich;

    @FXML
    void translateApi(ActionEvent event) throws IOException {
        String text = vanBan.getText().trim();

        String result = TextToText.translate("en", "vi", text);

        banDich.setText(result);
    }

}
