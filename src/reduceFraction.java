import java.util.*;
import java.io.*;

public class reduceFraction {
    public static String check(int N, int D) {
        int gcd = 1;
        for (int i = 1; i <= N && i <= D; i++) {
            if (N % i == 0 && D % i == 0) {
                gcd = i;
            }
        }

        N = N / gcd;
        D = D / gcd;

        if (N >= D) {
            int wholePart = N / D;
            int newNumerator = N % D;
            if (newNumerator == 0) {
                return wholePart + "";
            } else {
                return wholePart + " " + newNumerator + "/" + D;
            }
        } else {
            return N + "/" + D;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("fract.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int N = sc.nextInt(); // numerator
            int D = sc.nextInt(); // denominator
            System.out.println(check(N, D));
        }
    }
}