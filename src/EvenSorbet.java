import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class EvenSorbet {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("even.dat"));
        int numLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            String[] even = new String[words.length];
            int evenIndex = 0;

            // Collect even-length words
            for (String word : words) {
                if (word.length() % 2 == 0) {
                    even[evenIndex++] = word;
                }
            }

            // Sort even-length words
            Arrays.sort(even, 0, evenIndex);

            // Merge sorted even-length words back with odd-length words
            evenIndex = 0;
            for (String word : words) {
                if (word.length() % 2 == 0) {
                    System.out.print(even[evenIndex++] + " ");
                } else {
                    System.out.print(word + " ");
                }
            }
            System.out.println();
        }
    }
}