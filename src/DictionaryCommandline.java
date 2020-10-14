import java.util.Scanner;

public class DictionaryCommandline {

    public static void showAllWords() {
        System.out.println(String.format("%-30s %-1s %-30s %-1s %-30s", "No", "|", "English", "|", "Vietnamese"));
        for (int i = 0; i < Dictionary.words.size(); i++) {
            System.out.println(String.format("%-30s %-1s %-30s %-1s %-30s ",
                    i+1, "|", Dictionary.words.get(i).word_target, "|", Dictionary.words.get(i).word_explain));
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static void dictionaryAdvance() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }

    public static void dictionarySearcher() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap word: ");
        String word_input = input.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (Dictionary.words.get(i).word_target.startsWith(word_input)) {
                System.out.print(Dictionary.words.get(i).word_target + ", ");
            }
        }
    }

    public static void main(String[] args) {
        dictionaryAdvance();
        DictionaryManagement.dictionaryExportToFile();
        dictionarySearcher();
    }
}
