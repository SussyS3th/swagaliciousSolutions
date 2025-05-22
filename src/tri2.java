import java.util.*;
import java.io.*;

public class tri2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("6.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            String let = sc.nextLine().replaceAll(" ", "");
            for (int j = 1; j <= x; j++) {
                for (int k = 0; k < j; k++) {
                    System.out.print(let);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
