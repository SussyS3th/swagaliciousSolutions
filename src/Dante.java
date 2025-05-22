import java.util.*;
import java.io.*;

public class Dante {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dante.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        boolean[] isPrime = new boolean[100000001];
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
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            for (int j = Math.min(a, b); j < Math.max(a, b); j++) {
                if (isPrime[j]) count++;
            }
            System.out.println(count);
        }
    }
}