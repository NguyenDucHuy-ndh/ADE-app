package main.java;

import javafx.animation.*;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;

import javafx.util.Duration;

public class MyTranslateTransition {

    private final StackPane node;

    public MyTranslateTransition(StackPane node) {
        this.node = node;
    }

    public void playTransition() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), node);
        translateTransition.setFromY(-node.getBoundsInParent().getHeight());
        translateTransition.setToY(0);
        translateTransition.play();
    }
    public void playFadeTransition() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), node);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    public void playScaleTransition() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), node);
        scaleTransition.setFromX(0.0);
        scaleTransition.setFromY(0.0);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();
    }

    public void playRotateTransition() {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), node);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }

    public void playPathTransition() {
        // Assume you have a Path named path
        Path path = new Path();
        PathTransition pathTransition = new PathTransition(Duration.millis(500), path, node);
        pathTransition.play();
    }


}

