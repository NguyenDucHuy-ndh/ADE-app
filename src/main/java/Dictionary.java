package main.java;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Dictionary {
    private ObservableList<Word> wordList;

    public Dictionary() {
        wordList = FXCollections.observableArrayList();
    }

    public void addWord(Word word) {
        wordList.add(word);
    }

    public ObservableList<Word> getWordList() {
        return wordList;
    }

}