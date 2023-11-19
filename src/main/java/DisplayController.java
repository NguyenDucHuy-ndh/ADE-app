/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {

    @FXML // fx:id="exist"
    private Button exist; // Value injected by FXMLLoader

    @FXML // fx:id="search"
    private Button search; // Value injected by FXMLLoader

    @FXML // fx:id="about"
    private Button about; // Value injected by FXMLLoader

    @FXML // fx:id="account"
    private Button account; // Value injected by FXMLLoader

    @FXML // fx:id="home"
    private Button home; // Value injected by FXMLLoader

    @FXML
    protected BorderPane sear;
    @FXML
    protected  void hand_Clicks() throws IOException{
        try {
            // Load the FXML file
            BorderPane view = FXMLLoader.load(getClass().getResource("search.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setCenter(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(ActionEvent event) throws IOException {
        try {
            // Load the FXML file
            Parent view = FXMLLoader.load(getClass().getResource("search.fxml"));
            // Set the loaded view to the center of the BorderPane
            sear.setCenter(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
