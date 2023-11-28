package main.java;

import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class About implements Initializable {
    @FXML
    private StackPane mainGame;
    @FXML
    private AnchorPane mainAbout;
    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private Button animal;

    @FXML
    private Button items;



    @FXML
    private Button plant;





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


        DictionaryDAO dao = new DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "dung1asdf");
        dao.updateWord(_editTarget, _editDescription, _editMeaning);

        if (_editTarget.isEmpty() || _editDescription.isEmpty() || _editMeaning.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Edit");
            alert.setHeaderText("Vui long nhap thong tin can sua");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Edit");
            alert.setHeaderText("Sửa từ Thành công");
            alert.showAndWait();
        }
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
        DictionaryDAO dao = new DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "dung1asdf");
        dao.addWord(_addTarget, _addDescription, _addMeaning);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ADD");
        alert.setHeaderText("Bạn đã thêm từ thành công");
        Optional<ButtonType> result = alert.showAndWait();
    }
// end Add

    // Delete
    @FXML
    private TextField deleteTarget;

    @FXML
    void deleteWord(ActionEvent event) {
        String _deleteTarget = deleteTarget.getText().trim();

        DictionaryDAO dao = new DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "dung1asdf");
        dao.deleteWord(_deleteTarget);

        if (_deleteTarget.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Delete");
            alert.setHeaderText("Vui long nhap thong tin can xóa");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Xóa từ Thành công");
            alert.showAndWait();
        }
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
//            MyTranslateTransition myTranslateTransition = new MyTranslateTransition(loadAbout);
//            myTranslateTransition.playFadeTransition();
            new BounceInUp(loadAbout).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Add.fxml"));
            loadAbout.getChildren().removeAll();
            loadAbout.getChildren().setAll(view);
//            MyTranslateTransition myTranslateTransition = new MyTranslateTransition(loadAbout);
//            myTranslateTransition.playFadeTransition();
            new BounceInUp(loadAbout).play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void delete(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Delete.fxml"));
            loadAbout.getChildren().removeAll();
            loadAbout.getChildren().setAll(view);
            new BounceInUp(loadAbout).play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void game(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("GuessTheWord.fxml"));
            mainAbout.getChildren().removeAll();
            mainAbout.getChildren().setAll(view);
            new BounceInUp(mainAbout).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void animal(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Animal.fxml"));
            mainGame.getChildren().removeAll();
            mainGame.getChildren().setAll(view);
            new BounceInUp(mainGame).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void plant(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Plant.fxml"));
            mainGame.getChildren().removeAll();
            mainGame.getChildren().setAll(view);
            new BounceInUp(mainGame).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void items(ActionEvent actionEvent) {
        try {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Items.fxml"));
            mainGame.getChildren().removeAll();
            mainGame.getChildren().setAll(view);
            new BounceInUp(mainGame).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
