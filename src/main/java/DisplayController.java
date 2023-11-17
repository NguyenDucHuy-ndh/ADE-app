/**
 * Sample Skeleton for 'Display.fxml' Controller Class
 */

package main.java;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.awt.event.ActionEvent;

public class DisplayController {

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
}
