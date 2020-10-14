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

    public static void main(String[] args) {
        dictionaryAdvance();
        DictionaryManagement.dictionaryExportToFile();
    }
}
