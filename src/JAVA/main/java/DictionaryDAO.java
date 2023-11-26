package main.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DictionaryDAO {
    private  String url;
    private  String username;
    private  String password;

    public DictionaryDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void addWord(String wordTarget, String description, String wordExplain) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO mywords (wordTarget, description, wordExplain) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, wordTarget);
                statement.setString(2, description);
                statement.setString(3, wordExplain);

                int addRows = statement.executeUpdate();

                if (addRows > 0) {
                    System.out.println("Đã thêm từ thành công.");
                } else {
                    System.out.println("Thêm từ không thành công.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateWord(String wordTarget, String newDescription, String newWordExplain) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {

            String query = "UPDATE ten_bang SET description = ?, wordExplain = ? WHERE wordTarget = ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {

                statement.setString(1, wordTarget);
                statement.setString(2, newDescription);
                statement.setString(3, newWordExplain);

                int updateRows = statement.executeUpdate();

                if (updateRows > 0) {
                    System.out.println("Đã cập nhật từ thành công.");
                } else {
                    System.out.println("Không tìm thấy từ cần cập nhật.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void deleteWord(String wordTarget) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM mywords WHERE wordTarget = ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, wordTarget);

                int deleteRows = statement.executeUpdate();

                if (deleteRows > 0) {
                    System.out.println("Đã xóa từ thành công.");
                } else {
                    System.out.println("Xóa từ không thành công.");
                }
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
                        String _description = resultSet.getString("description");
                        String _wordExplain = resultSet.getString("wordExplain");
                        System.out.println(_wordTarget + " - " + _description + " - " + _wordExplain);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public String[] getWordInfo(String wordTarget) {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT wordTarget, description, wordExplain FROM mywords WHERE wordTarget LIKE ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, wordTarget + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String[] wordInfo = new String[3];
                        wordInfo[0] = resultSet.getString("wordTarget");
                        wordInfo[1] = resultSet.getString("description");
                        wordInfo[2] = resultSet.getString("wordExplain");
                        return wordInfo;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    public void showAll() {
        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM mywords";
            try(Statement statement = connect.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        String _wordTarget = resultSet.getString("wordTarget");
                        String _description = resultSet.getString("description");
                        String _wordExplain = resultSet.getString("wordExplain");
                        System.out.println(_wordTarget + " - " + _description + " - " + _wordExplain);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<String> searchWord2(String searchWord) {
        ObservableList<String> searchResults = FXCollections.observableArrayList();

        try (Connection connect = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT wordTarget FROM mywords WHERE wordTarget LIKE ?";
            try (PreparedStatement statement = connect.prepareStatement(query)) {
                statement.setString(1, searchWord + "%");

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String wordTarget = resultSet.getString("wordTarget");
                        searchResults.add(wordTarget);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return searchResults;
    }


}

