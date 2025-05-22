import java.util.*;
import java.io.*;

public class factorial {
    public static long fact(int n) {
        if (n == 0) return n+1;
        return n * fact(n - 1);
    }
    public static void main(String [] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("factorials.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        //print factorials between the two numbers

        for (int i = 0; i < n; i++) {
            int lowFact = sc.nextInt();
            int highFact = sc.nextInt();
//            System.out.print(low + " ");

            for (int zz = lowFact; zz < highFact+1; zz++) {
                System.out.print(fact(zz) + " ");
            }
            System.out.println();
        }
    }
}
