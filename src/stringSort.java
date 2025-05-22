import java.util.*;
import java.io.*;

public class stringSort {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sort.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                char[] c = arr[j].toCharArray();
                Arrays.sort(c);
                arr[j] = String.valueOf(c);
                System.out.print(arr[j] + " ");
            }
        System.out.println();
        }
    }
}
