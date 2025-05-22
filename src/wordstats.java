import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class wordstats {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr75.dat"));
        String str = scanner.nextLine();
        scanner.close();

        int vowels = 0;
        int consonants = 0;
        int spaces = 0;
        int other = 0;
        int words = 0;
        int longestWord = 0;
        int shortestWord = Integer.MAX_VALUE;
        int totalWordLength = 0;

        String[] wordArray = str.split(" ");
        words = wordArray.length;

        for (String word : wordArray) {
            int wordLength = word.length();
            totalWordLength += wordLength;
            if (wordLength > longestWord) {
                longestWord = wordLength;
            }
            if (wordLength < shortestWord) {
                shortestWord = wordLength;
            }
        }

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("AEIOUaeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (c == ' ') {
                spaces++;
            } else {
                other++;
            }
        }

        double averageWordLength = (double) totalWordLength / words;

        System.out.printf("VOWELS - %d\n", vowels);
        System.out.printf("CONSONANTS - %d\n", consonants);
        System.out.printf("SPACE - %d\n", spaces);
        System.out.printf("OTHER - %d\n", other);
        System.out.printf("WORDS - %d\n", words);
        System.out.printf("LONGEST - %d\n", longestWord);
        System.out.printf("SHORTEST - %d\n", shortestWord);
        System.out.printf("AVERAGE - %.1f\n", averageWordLength);
    }
}