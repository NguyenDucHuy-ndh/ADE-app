//package main.java;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.FileInputStream;
//import java.sql.*;
//import java.util.Objects;
//
//public class Main extends Application {
//    public static void main(String[] args) {
//
//        /*
//        Word word1 = new Word("Hello", "Xin chào");
//        Word word2 = new Word("House", "Ngôi nhà");
//        Word word3 = new Word("Love", "Yêu thương");
//
//        Dictionary dictionary = new Dictionary();
//
//        dictionary.addWord(word3);
//        dictionary.addWord(word1);
//        dictionary.addWord(word2);
//
//        DictionaryCommandline d = new DictionaryCommandline(dictionary);
//        d.dictionaryAdvanced();
//        */
//
//        /*
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");
//
//            Statement statement = conn.createStatement();
//            String query = "SELECT * FROM mywords";
//
//
//            ResultSet resultSet = statement.executeQuery(query);
//
//
//            while (resultSet.next()) {
//                // Đọc dữ liệu từ cột trong kết quả
//                String wordTarget = resultSet.getString("wordTarget");
//                String wordExplain = resultSet.getString("wordExplain");
//                System.out.println(wordTarget + " - " + wordExplain);
//            }
//
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        */
//
//        //DictionaryDAO dao = new DictionaryDAO("jdbc:mysql://127.0.0.1:3306/dictionarydb", "root", "123456");
//
//        //dao.showAll();
//        launch(args);
//
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
//        primaryStage.setTitle("Dictionary App");
//        Scene scene = new Scene(root);
//        //primaryStage.initStyle(StageStyle.UNDECORATED);
//        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/app_icon.png")));
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//    }
//}
