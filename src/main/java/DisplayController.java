/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
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
