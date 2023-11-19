package main.java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private BorderPane B_pane;

    @FXML
    private Label grammarLabel;

    @FXML
    private ListView<?> listEnglish;

    @FXML
    private TextField searchText;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
