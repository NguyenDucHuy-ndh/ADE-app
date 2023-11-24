package main.java;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
    private BorderPane loadAbout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void edit(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Edit.fxml"));
            loadAbout.setRight(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Add.fxml"));
            loadAbout.setRight(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            loadAbout.setRight(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
