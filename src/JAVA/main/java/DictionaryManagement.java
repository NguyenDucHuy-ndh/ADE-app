package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

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
    private int binarySearch(List<Word> wordList, String target) {
        int low = 0;
        int high = wordList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midWord = wordList.get(mid).getWordTarget().toLowerCase();

            if (midWord.equals(target)) {
                return mid; // Found the word
            } else if (midWord.compareTo(target) < 0) {
                low = mid + 1; // Search the right half
            } else {
                high = mid - 1; // Search the left half
            }
        }

        return -1; // Word not found
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
        String lkWord = sc.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

        // Sort the word list to enable binary search
        Collections.sort(dictionary.getWordList(), Comparator.comparing(Word::getWordTarget));

        int index = binarySearch(dictionary.getWordList(), lkWord);

        if (index != -1) {
            Word word = dictionary.getWordList().get(index);
            System.out.println("Từ vựng: " + word.getWordTarget());
            System.out.println("Giải nghĩa: " + word.getWordExplain());
        } else {
            System.out.println("Không tìm thấy từ trong từ điển.");
        }
    }

    public void addWordCommandline() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập từ cần thêm: ");
        String wordTarget = sc.nextLine().toLowerCase(); // Convert to lowercase for case-insensitive comparison

        System.out.print("Nhập nghĩa tiếng Việt: ");
        String wordExplain = sc.nextLine();

        Word newWord = new Word(wordTarget, wordExplain);

        // Use a HashSet to quickly check if the word already exists
        Set<String> existingWords = dictionary.getWordList()
                .stream()
                .map(Word::getWordTarget)
                .collect(Collectors.toSet());

        if (existingWords.contains(wordTarget)) {
            System.out.println("Từ vựng đã có sẵn trong từ điển!");
        } else {
            dictionary.addWord(newWord);
            System.out.println("Thêm từ thành công!");
        }
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

