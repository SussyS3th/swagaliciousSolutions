import java.util.*;
import java.io.*;

public class ana_bananagrams {

    public static Map<String, List<String>> anagrams = new HashMap<>();

    public static void anagram(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        if (!anagrams.containsKey(sorted)) {
            anagrams.put(sorted, new ArrayList<>());
        }
        anagrams.get(sorted).add(word);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("anagrams.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] words = line.split(" ");


        }
    }
}
