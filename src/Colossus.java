import java.util.*;
import java.io.*;

public class Colossus {
    public static void main (String[] args) throws  FileNotFoundException {
        Scanner sc = new Scanner(new File("colossus.dat"));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            if (x > 10000) {
                System.out.println("Lunk Alarm!!");
            } else {
                System.out.println("Hulk here we come.");
            }
        }

    }
}
