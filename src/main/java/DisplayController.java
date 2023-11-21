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

//    @FXML
//    public void hand_Clicks(ActionEvent event) throws IOException {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
//            Parent root = loader.load();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public void search(ActionEvent event) throws IOException {
//        try {
//            // Load the FXML file
//            Parent view = FXMLLoader.load(getClass().getResource("search.fxml"));
//            // Set the loaded view to the center of the BorderPane
//            sear.setCenter(view);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
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


}
