import java.util.*;
import java.io.*;

public class groupof3ism {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr30.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            // add a space every 3 characters
            for (int j = 0; j < line.length(); j++) {
                sb.append(line.charAt(j));
                if ((j + 1) % 3 == 0) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
