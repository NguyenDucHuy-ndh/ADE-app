package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private StackPane loadAbout;

// Edit
    @FXML
    private TextField editTarget;

    @FXML
    private TextField editDescription;

    @FXML
    private TextField editMeanig;

    @FXML
    void editWord(ActionEvent event) {

    }
// Edit

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void edit(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Edit.fxml"));
            loadAbout.getChildren().removeAll();
            loadAbout.getChildren().setAll(view);
            MyTranslateTransition myTranslateTransition = new MyTranslateTransition(loadAbout);
            myTranslateTransition.playFadeTransition();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Add.fxml"));
            loadAbout.getChildren().removeAll();
            loadAbout.getChildren().setAll(view);
            MyTranslateTransition myTranslateTransition = new MyTranslateTransition(loadAbout);
            myTranslateTransition.playFadeTransition();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            loadAbout.getChildren().removeAll();
            loadAbout.getChildren().setAll(view);
            MyTranslateTransition myTranslateTransition = new MyTranslateTransition(loadAbout);
            myTranslateTransition.playFadeTransition();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
