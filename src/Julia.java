import java.util.*;
import java.io.*;

public class Julia {
    public static boolean[] isPrime;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("julia.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        isPrime = new boolean[100000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= 100000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 100000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            long num = sc.nextInt();
            for (int j = 1; j <= num; j++) {
                if (isPrime[j]) count++;
            }
            System.out.println(count);
        }
    }
}