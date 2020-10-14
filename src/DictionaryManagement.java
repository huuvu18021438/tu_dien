import java.io.*;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class DictionaryManagement {
    public static void nhap() {
        Scanner input = new Scanner(System.in);
        Word word = new Word();
        System.out.print("Nhap tu tieng Anh: ");
        word.word_target = input.nextLine();
        System.out.print("Nhap nghia: ");
        word.word_explain = input.nextLine();
        Dictionary.words.add(word);
    }

    public static void insertFromCommandline() {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            nhap();
        }
    }

    public static void insertFromFile() {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("C:/tmp/dictionaries.txt"));
            ArrayList<String> target = new ArrayList<>();
            ArrayList<String> explain = new ArrayList<>();
            String line = null;
            String[] wordsArray;

            while (true) {
                line = buf.readLine();
                if (line == null) {
                    break;
                } else {
                    wordsArray = line.split("\t");
                    for (int i = 0; i < wordsArray.length; i++) {
                        if (i % 2 == 0) {
                            target.add(wordsArray[i]);
                        } else {
                            explain.add(wordsArray[i]);
                        }
                    }
                }
            }
            for (int j = 0; j < target.size(); j++) {
                Word w = new Word(target.get(j), explain.get(j));
                Dictionary.words.add(w);
            }
            buf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        System.out.print("Tra bang dong lenh: ");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String result = "Not found";
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (word.equals(Dictionary.words.get(i).word_target)) {
                result = word + " " + Dictionary.words.get(i).word_explain;
            }
            if (word.equals(Dictionary.words.get(i).word_explain)) {
                result = word + " " + Dictionary.words.get(i).word_target;
            }
        }
        System.out.println(result);
    }

    public static void addWord() {
        Scanner input = new Scanner(System.in);
        Word word = new Word();
        System.out.print("Nhap tu tieng anh: ");
        word.word_target = input.nextLine();
        System.out.print("Nhap giai nghia: ");
        word.word_explain = input.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (word.word_target.equals(Dictionary.words.get(i).word_target)) {
                System.out.println("Tu da co trong mang!");
            } else {
                Dictionary.words.add(word);
            }
            break;
        }
    }

    public static void fixWord() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tu can sua: ");
        String w = input.nextLine();
        Word word = new Word();
        System.out.print("Nhap tu da sua: ");
        word.word_target = input.nextLine();
        System.out.print("Nhap nghia da sua: ");
        word.word_explain = input.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (w.equals(Dictionary.words.get(i).word_target)) {
                Dictionary.words.set(i, word);
            } else if (w.equals(Dictionary.words.get(i).word_explain)) {
                Dictionary.words.set(i, word);
            } else {
                System.out.println("Khong tim thay tu can sua!");
            }
            break;
        }
    }

    public static void removeWord() {
        Scanner input = new Scanner(System.in);
        System.out.print("Tu can xoa: ");
        String word = input.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if (word.equals(Dictionary.words.get(i).word_target)) {
                Dictionary.words.remove(i);
            } else if (word.equals(Dictionary.words.get(i).word_explain)) {
                Dictionary.words.remove(i);
            } else {
                System.out.println("Khong tim thay tu!");
            }
            break;
        }
    }

    public static void dictionaryExportToFile() {
        try {
            File f = new File("C:/tmp/fileword.txt");
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < Dictionary.words.size(); i++) {
                fw.write(Dictionary.words.get(i).word_target + "\t" + Dictionary.words.get(i).word_explain + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

