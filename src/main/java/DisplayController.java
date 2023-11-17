/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {

    @FXML // fx:id="exist"
    private Button exist; // Value injected by FXMLLoader

    @FXML // fx:id="search"
    private ImageView search; // Value injected by FXMLLoader

    @FXML // fx:id="about"
    private Button about; // Value injected by FXMLLoader

    @FXML // fx:id="account"
    private Button account; // Value injected by FXMLLoader

    @FXML // fx:id="home"
    private Button home; // Value injected by FXMLLoader

    @FXML
    void hand_Clicks(ActionEvent event) {

    }

    public void hand_Clicks(javafx.event.ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
