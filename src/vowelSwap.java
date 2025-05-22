import java.util.*;
import java.io.*;

public class vowelSwap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr87.dat"));
        int numLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            for (char ch: line.toCharArray()) {
                if (ch == 'a') result.append('e');
                else if (ch == 'e') result.append('i');
                else if (ch == 'i') result.append('o');
                else if (ch == 'o') result.append('u');
                else if (ch == 'u') result.append('a');
                else if (ch == 'A') result.append('E');
                else if (ch == 'E') result.append('I');
                else if (ch == 'I') result.append('O');
                else if (ch == 'O') result.append('U');
                else if (ch == 'U') result.append('A');
                else result.append(ch);
            }
            System.out.println(result);
        }
    }
}
