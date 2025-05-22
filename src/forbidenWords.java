import java.util.*;
import java.io.*;

public class forbidenWords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("forbidden.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while (noSets-- > 0) {
            String toCheck = scan.nextLine().toLowerCase().replaceAll("[\\s\\W]", "");
            String[] words = scan.nextLine().split(" ");
            for (int i = 0; i < words.length; i++) words[i] = words[i].toLowerCase();
            String wordy;
            int highestSubstring = 0;
            for (int i = 0; i < toCheck.length(); i++) {
                wordy = toCheck.substring(i, i + 1);
                loop:
                for (int j = i + 1; j < toCheck.length(); j++) {
                    String a = wordy;
                    wordy += toCheck.substring(j, j + 1);
                    for (String word : words) {
                        if (wordy.contains(word)) {
                            wordy = a;
                            break loop;
                        }
                        ;
                    }
                }
                if (highestSubstring < wordy.length()) highestSubstring = wordy.length();
            }
            System.out.println(highestSubstring);
        }
    }
}

