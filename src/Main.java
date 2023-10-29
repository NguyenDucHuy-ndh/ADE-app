package main;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("Hello", "Xin chào");
        Word word2 = new Word("House", "Ngôi nhà");
        Word word3 = new Word("Love", "Yêu thương");

        Dictionary dictionary = new Dictionary();

        dictionary.addWord(word3);
        dictionary.addWord(word1);
        dictionary.addWord(word2);

        DictionaryCommandline d = new DictionaryCommandline(dictionary);
        d.dictionaryAdvanced();

    }
}
