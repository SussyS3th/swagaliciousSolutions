import java.util.*;
import java.io.*;

public class reversal {
    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
    //File code was wrong -> on the 3rd line add an uppercase I to the last word

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("reverse.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : line) {
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (isLowerCase(c)) {
                        sb.append(Character.toUpperCase(c));
                    } else if (isUpperCase(c)) {
                        sb.append(Character.toLowerCase(c));
                    } else {
                        sb.append(c);
                    }
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
