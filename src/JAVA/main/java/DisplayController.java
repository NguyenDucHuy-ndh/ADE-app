/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

import animatefx.animation.BounceInDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {

    @FXML
    private StackPane mainFace;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            AnchorPane fxml = FXMLLoader.load(getClass().getResource("HOME.fxml"));
//            mainFace.getChildren().removeAll();
//            mainFace.getChildren().setAll(fxml);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void search(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane fxml = FXMLLoader.load(getClass().getResource("search.fxml"));
        mainFace.getChildren().removeAll();
        mainFace.getChildren().setAll(fxml);
        MyTranslateTransition myTranslateTransition = new MyTranslateTransition(mainFace);
        myTranslateTransition.playFadeTransition();
    }

    /**
     * @param actionEvent .
     */
    public void home (javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane fxml = FXMLLoader.load(getClass().getResource("HOME.fxml"));
        mainFace.getChildren().removeAll();
        mainFace.getChildren().setAll(fxml);
        MyTranslateTransition myTranslateTransition = new MyTranslateTransition(mainFace);
        myTranslateTransition.playFadeTransition();
    }
    public  void account (javafx.event.ActionEvent actionEvent) throws IOException{
        AnchorPane fxml = FXMLLoader.load(getClass().getResource("Account.fxml"));
        mainFace.getChildren().removeAll();
        mainFace.getChildren().setAll(fxml);
        MyTranslateTransition myTranslateTransition = new MyTranslateTransition(mainFace);
        myTranslateTransition.playFadeTransition();
    }
    public void about (javafx.event.ActionEvent actionEvent) throws IOException{
        AnchorPane fxml = FXMLLoader.load(getClass().getResource("About.fxml"));
        mainFace.getChildren().removeAll();
        mainFace.getChildren().setAll(fxml);
        MyTranslateTransition myTranslateTransition = new MyTranslateTransition(mainFace);
        myTranslateTransition.playFadeTransition();
    }


    public void exist(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("Do you want exit?");
        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().getButtonData() == ButtonBar.ButtonData.YES) {
            System.exit(0);
        }
    }

    public void translate(ActionEvent actionEvent) throws IOException{
        AnchorPane fxml = FXMLLoader.load(getClass().getResource("Translate.fxml"));
        mainFace.getChildren().removeAll();
        mainFace.getChildren().setAll(fxml);
        MyTranslateTransition myTranslateTransition = new MyTranslateTransition(mainFace);
        myTranslateTransition.playFadeTransition();
    }

}
