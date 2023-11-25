/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

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

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {


    @FXML
    private Button Search;

    @FXML
    private Button about;

    @FXML
    private Button account;

    @FXML
    private Button exist;

    @FXML
    private Button home;

    @FXML
    private BorderPane sear;

    @FXML
    private BorderPane B_pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void search(javafx.event.ActionEvent actionEvent) {
        try {
            // Load the FXML file
            AnchorPane view = FXMLLoader.load(getClass().getResource("search.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setRight(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param actionEvent .
     */
    public void home (javafx.event.ActionEvent actionEvent) {
        try {
            // Load the FXML file
            AnchorPane view = FXMLLoader.load(getClass().getResource("HOME.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setRight(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void account (javafx.event.ActionEvent actionEvent) {
        try {
            // Load the FXML file
            AnchorPane view = FXMLLoader.load(getClass().getResource("Account.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setRight(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void about (javafx.event.ActionEvent actionEvent) {
        try {
            // Load the FXML file
            AnchorPane view = FXMLLoader.load(getClass().getResource("About.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setRight(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void translate(ActionEvent actionEvent) {
        try {
            // Load the FXML file
            AnchorPane view = FXMLLoader.load(getClass().getResource("Translate.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setRight(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
