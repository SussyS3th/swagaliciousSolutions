import java.util.*;
import java.io.*;

public class anishious_Crashout {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("anisha.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int curr = sc.nextInt();
            int max = sc.nextInt();

            if (curr < 15) System.out.println("On my way to Dehydration Station.");
            else System.out.println("Way to go, H2O.");
        }
    }
}
