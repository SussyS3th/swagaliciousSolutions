import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class Permute {
    static List<String> list = new ArrayList<>();

public static void permute(String word, String result, int length) {
    if (result.length() == length) {
        System.out.println(result);
        return;
    }

    for (int i = 0; i < word.length(); i++) {
        String toAdd = word.substring(0,i)+ word.substring(i+1);
        permute(toAdd, result + word.charAt(i), length);
        }

    }

public static void main(String[]args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("pr150.dat"));
    int numLines = scanner.nextInt();

    for (int i = 0; i < numLines; i++) {
        String word = scanner.next();
        int length = scanner.nextInt();
        permute(word, "", length);
        list.forEach(a->System.out.print(a+" "));
    }
}
}
