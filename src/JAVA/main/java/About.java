package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    private TextField editMeaning;

    @FXML
    void editWord(ActionEvent event) {
        String _editTarget = editTarget.getText().trim();
        String _editDescription = editDescription.getText().trim();
        String _editMeaning = editMeaning.getText().trim();


        DictionaryDAO dao = new  DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");
        dao.updateWord(_editTarget, _editDescription, _editMeaning);
    }
// end Edit

// Add
    @FXML
    private TextField addTarget;

    @FXML
    private TextField addDescription;

    @FXML
    private TextField addMeaning;

    @FXML
    void addWord(ActionEvent event) {
        String _addTarget = addTarget.getText().trim();
        String _addDescription = addDescription.getText().trim();
        String _addMeaning = addMeaning.getText().trim();


        DictionaryDAO dao = new  DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");
        dao.addWord(_addTarget, _addDescription, _addMeaning);
    }
// end Add

// Delete
    @FXML
    private TextField deleteTarget;

    @FXML
    void deleteWord(ActionEvent event) {
        String _deleteTarget = deleteTarget.getText().trim();

        DictionaryDAO dao = new  DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");
        dao.deleteWord(_deleteTarget);
    }
// end Delete

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
