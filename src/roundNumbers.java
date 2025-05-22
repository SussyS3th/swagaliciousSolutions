import java.util.*;
import java.io.*;
public class roundNumbers {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr18.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println("ROUNDING IS FUN");

             for (int j = 1; j <= num; j++) {
                 String x = ("  " + j + "   " + String.format("%.1f", Math.sqrt(j)) + "    " + String.format("%.2f", Math.cbrt(j)));
                 String y = (" " + j + "   " + String.format("%.1f", Math.sqrt(j)) + "    " + String.format("%.2f", Math.cbrt(j)));
                 if (j < 10) System.out.println(x);
                 if (j >= 10) System.out.println(y);
             }
             System.out.println();
        }

    }
}
