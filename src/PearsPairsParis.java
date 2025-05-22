import java.io.*;
import java.util.*;

public class PearsPairsParis {
    public static void check(int[] pears, int target) {
        int closestSum = Integer.MAX_VALUE;
        int closestIdx1 = -1;
        int closestIdx2 = -1;

        for (int i = 0; i < pears.length; i++) {
            for (int j = i + 1; j < pears.length; j++) {
                int sum = pears[i] + pears[j];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                    closestIdx1 = i;
                    closestIdx2 = j;
                }
            }
        }

        System.out.println(closestIdx1 + " " + closestIdx2);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pears.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            sc.nextLine();
            String[] pearStrings = sc.nextLine().split(" ");
            int[] pears = new int[pearStrings.length];
            for (int j = 0; j < pearStrings.length; j++) {
                pears[j] = Integer.parseInt(pearStrings[j]);
            }
            check(pears, target);
        }
    }
}