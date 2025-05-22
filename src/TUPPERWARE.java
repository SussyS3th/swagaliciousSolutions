import java.util.*;
import java.io.*;

public class TUPPERWARE {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("tupperware.dat"));
        int height = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            for (int j = 0; j < arr.length; j++) {
                total += arr[j];
            }
            if (total < height) System.out.println("STUCK FOREVER");
             else System.out.println("ESCAPABLE");
        }
    }
}
