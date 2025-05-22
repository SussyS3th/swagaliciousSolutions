import java.util.*;
import java.io.*;

public class PDiddy_ism {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("babyOil.dat"));
        int oil = 0; // max weight
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            oil = sc.nextInt();
            sc.nextLine();
            int[] ws = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] vs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // output the maximum value of circuits you cn steal with the given weight constraints

            int[] diddy = new int[oil + 1];
            for (int j = 0; j < ws.length; j++) {
                for (int k = oil; k >= ws[j]; k--) {
                    diddy[k] = Math.max(diddy[k], diddy[k - ws[j]] + vs[j]);
                }
            }
            System.out.println(diddy[oil]);

        }
    }
}
