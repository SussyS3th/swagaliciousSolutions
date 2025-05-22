import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;


public class WordSort {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("pr03.dat"));
        String[] words = null;
        int numLines = scanner.nextInt();
        scanner.nextLine();

        //order the words in each line alphabetically and remove punctuation

        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            words = line.split("\\s+");
            for (int j = 0; j < words.length; j++) {
                words[j] = words[j].replaceAll("[^a-zA-Z]", "");
            }
            Comparator<String> comp = ((a, b) -> {
                if (a.toLowerCase().equals(b.toLowerCase()))
                    return a.compareTo(b);
                return a.toUpperCase().compareTo(b.toUpperCase());
            });
            Arrays.sort(words,comp);
            for (int j = 0; j < words.length; j++) {
                System.out.print(words[j] + " ");
            }
            System.out.println();
        }


    }
}
