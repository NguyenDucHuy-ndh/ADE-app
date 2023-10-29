package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng từ vựng: ");
        int n = sc.nextInt();
        sc.nextLine(); // Xóa bộ đệm bàn phím

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập từ tiếng Anh: ");
            String wordTarget = sc.nextLine();

            System.out.print("Nhập giải thích tiếng Việt: ");
            String wordExplain = sc.nextLine();

            Word newWord = new Word(wordTarget, wordExplain);
            dictionary.addWord(newWord);
        }

    }

    public void insertFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] list = line.split("\t");
                if (list.length >= 2) {
                    String wordTarget = list[0];
                    String wordExplain = list[1];

                    Word newWord = new Word(wordTarget, wordExplain);
                    dictionary.addWord(newWord);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void dictionaryExportToFile(String fileName) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName, StandardCharsets.UTF_8);
            for (Word word : dictionary.getWordList()) {
                printWriter.println(word.getWordTarget() + "\t" + word.getWordExplain());
            }
            printWriter.flush();
            printWriter.close();
            System.out.println("Xuất dữ liệu từ điển thành công.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập từ cần tra cứu: ");
        String lkWord = sc.nextLine();
        boolean isFound = false;

        for (Word word : dictionary.getWordList()) {
            if (word.getWordTarget().equalsIgnoreCase(lkWord)) {
                System.out.println("Từ vựng: " + word.getWordTarget());
                System.out.println("Giải nghĩa: " + word.getWordExplain());
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy từ trong từ điển.");
        }

    }

    public void addWordCommandline() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập từ cần thêm: ");
        String wordTarget = sc.nextLine();

        System.out.print("Nhập nghĩa tiếng Việt: ");
        String wordExplain = sc.nextLine();

        Word newWord = new Word(wordTarget, wordExplain);
        for (Word word : dictionary.getWordList()) {
            if (word.getWordTarget().equalsIgnoreCase(newWord.getWordTarget())) {
                System.out.println("Từ vựng đã có sẵn trong từ điển!");
                return;
            }
        }

        dictionary.addWord(newWord);
        System.out.println("Thêm từ thành công!");

    }

    public void editWordCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập từ tiếng Anh cần sửa: ");
        String oldWord = scanner.nextLine();

        System.out.print("Nhập từ tiếng Anh thay thế: ");
        String newWordTarget = scanner.nextLine();

        System.out.print("Nhập giải nghĩa tiếng Việt mới: ");
        String newWordExplain = scanner.nextLine();

        Word editedWord = new Word(newWordTarget, newWordExplain);
        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            if (dictionary.getWordList().get(i).getWordTarget().equalsIgnoreCase(oldWord)) {
                dictionary.getWordList().set(i, editedWord);
                System.out.println("Sửa từ thành công.");

                return;
            }
        }
        System.out.println("Không tìm thấy từ cần sửa trong từ điển.");

    }

    public void deleteWordCommandline() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập từ tiếng Anh cần xóa: ");
        String wordDelete = scanner.nextLine();

        for (int i = 0; i < dictionary.getWordList().size(); i++) {
            if (dictionary.getWordList().get(i).getWordTarget().equalsIgnoreCase(wordDelete)) {
                dictionary.getWordList().remove(i);
                System.out.println("Xóa từ thành công.");

                return;
            }
        }
        System.out.println("Không tìm thấy từ cần xóa trong từ điển.");

    }
}

