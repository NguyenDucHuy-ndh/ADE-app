package main.java;

import animatefx.animation.BounceInUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public abstract class Game {

<<<<<<< HEAD

    public abstract void initialize();
    public abstract String getCurentWord();
    public abstract void handleGuess(String guessedWord);

}
=======
    public abstract void initialize();
    public abstract String getCurentWord();
    public abstract void handleGuess();

}
>>>>>>> 4f41f170831f01e0f836567b4a99974a1082e0db
