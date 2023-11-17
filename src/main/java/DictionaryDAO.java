package main.java;
import  java.sql.*;

public class DictionaryDAO {
    private  String url;
    private  String username;
    private  String password;

    public DictionaryDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void addWord(String wordTarget, String wordExplain) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO mywords (wordTarget, wordExplain) VALUES (?, ?)";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, wordTarget);
                statement.setString(2, wordExplain);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteWord(String wordTarget, String wordExplain) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM mywords WHERE wordTarget = ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, wordTarget);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchWord(String searchWord) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM ten_bang WHERE wordTarget LIKE ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, searchWord + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String _wordTarget = resultSet.getString("wordTarget");
                        String _wordExplain = resultSet.getString("wordExplain");
                        System.out.println(_wordTarget + " - " + _wordExplain);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void showAll() {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM mywords";
            try(Statement statement = connect.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        String _wordTarget = resultSet.getString("wordTarget");
                        String _wordExplain = resultSet.getString("wordExplain");
                        System.out.println(_wordTarget + " - " + _wordExplain);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

