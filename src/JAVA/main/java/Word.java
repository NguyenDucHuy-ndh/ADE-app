package main.java;

import animatefx.animation.BounceInUp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Word {

    private String word_target; // Từ vựng tiếng Anh
    private String word_explain; // Giải nghĩa tiếng Việt

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }


    public String getWordTarget() {
        return word_target;
    }

    public String getWordExplain() {
        return word_explain;
    }
    public final String getWord() {
        return word.get();
    }

    public final StringProperty wordProperty() {
        return word;
    }

    public final void setWord(String value) {
        this.word.set(value);

    }
    private final StringProperty word = new SimpleStringProperty(this, "word");

    public Word(String word) {
        setWord(word);
    }
}

