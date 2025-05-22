import java.util.*;
import java.io.*;

public class rotations {
    public static boolean areRotations(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
    public static void main (String [] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr83.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            String s1 = line[0];
            String s2 = line[1];
            System.out.println(areRotations(s1, s2) ? "YES" : "NO");
        }

    }
}
