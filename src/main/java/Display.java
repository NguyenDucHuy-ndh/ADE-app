package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Objects;

public class Display extends Application {
    @FXML // fx:id="exist"
    private Button exist; // Value injected by FXMLLoader

    @FXML // fx:id="sear"
    private Button sear; // Value injected by FXMLLoader

    @FXML // fx:id="about"
    private Button about; // Value injected by FXMLLoader

    @FXML // fx:id="account"
    private Button account; // Value injected by FXMLLoader

    @FXML // fx:id="home"
    private Button home; // Value injected by FXMLLoader

    @FXML
    void hand_Clicks(java.awt.event.ActionEvent event) {

    }

    public void hand_Clicks(javafx.event.ActionEvent actionEvent) {
    } public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
        primaryStage.setTitle("Dictionary App");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


}

