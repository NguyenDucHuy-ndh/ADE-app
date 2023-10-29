import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandline {

    private Dictionary dictionary;
    private DictionaryManagement dictionaryManagement;

    public DictionaryCommandline(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.dictionaryManagement = new DictionaryManagement(dictionary);
    }

    class ReverseAlphabeticalComparator implements Comparator<Word> {
        @Override
        public int compare(Word w1, Word w2) {
            return w1.getWordTarget().compareTo(w2.getWordTarget());
        }
    }
    public void showAllWords() {
        // Sắp xếp danh sách từ vựng theo thứ tự alphabet
        Collections.sort(dictionary.getWordList(), new ReverseAlphabeticalComparator());

        // Hiển thị danh sách từ vựng
        System.out.println("No   | English   | Vietnamese");
        System.out.println("----------------------------");
        int count = 1;
        for (Word word : dictionary.getWordList()) {
            System.out.format("%-5d| %-10s| %s\n", count, word.getWordTarget(), word.getWordExplain());
            count++;
        }
    }


    public void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập từ cần tìm kiếm: ");
        String searchWord = scanner.nextLine();

        ArrayList<Word> search = new ArrayList<>();


        for (Word word : dictionary.getWordList()) {
            if (word.getWordTarget().toLowerCase().startsWith(searchWord.toLowerCase())) {
                search.add(word);
            }
        }

        if (search.isEmpty()) {
            System.out.println("Không tìm thấy từ nào phù hợp.");
        } else {
            System.out.print("Kết quả trả về: ");
            for (int i = 0; i < search.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(search.get(i).getWordTarget());
            }
            System.out.println();
        }

    }

    public void dictionaryBasic() {
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        do {
            System.out.println("Chọn phương thức:");
            System.out.println("1. insertFromCommandline()");
            System.out.println("2. showAllWords()");
            System.out.println("0. exits()");

            int keyboard =  sc.nextInt();
            switch (keyboard) {
                case 0:
                    bool = false;
                case 1:
                    dictionaryManagement.insertFromCommandline();
                    break;
                case 2:
                    showAllWords();
                    break;
                default:
                    System.out.println("Yêu cầu không hợp lệ!");
                    break;
            }
        } while (bool);

        sc.close();
    }

    public void dictionaryAdvanced() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to My Application!");
            System.out.println("[0]   Exit");
            System.out.println("[1]   Add");
            System.out.println("[2]   Remove");
            System.out.println("[3]   Update");
            System.out.println("[4]   Display");
            System.out.println("[5]   Lookup");
            System.out.println("[6]   Search");
            System.out.println("[7]   Game");
            System.out.println("[8]   Import from file");
            System.out.println("[9]   Export to file");
            System.out.print("Your action: ");

            int keyboard = sc.nextInt();

            switch (keyboard) {
                case 0:
                    System.out.println("Exiting the application.");
                    sc.close();
                    return;
                case 1:
                    dictionaryManagement.addWordCommandline();
                    break;
                case 2:
                    dictionaryManagement.deleteWordCommandline();
                    break;
                case 3:
                    dictionaryManagement.editWordCommandline();
                    break;
                case 4:
                    showAllWords();
                    break;
                case 5:
                    dictionaryManagement.dictionaryLookup();
                    break;
                case 6:
                    dictionarySearcher();
                    break;
                case 7:

                    break;
                case 8:
                    dictionaryManagement.insertFromFile("D:\\app\\dictionaries.txt"); // Thay đổi tên tệp tùy ý
                    break;
                case 9:
                    dictionaryManagement.dictionaryExportToFile("D:\\app\\output.txt"); // Thay đổi tên tệp tùy ý
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
