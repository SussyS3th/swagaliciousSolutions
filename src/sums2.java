import java.util.*;
import java.io.*;

public class sums2 {
    public static long sumRange(long start, long end) {
        long sum = 0;
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sum.dat"));
        int numDataSets = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numDataSets; i++) {
            String line = sc.nextLine();
            String[] numsStr = line.split(" ");
            long totalSum = 0;

            for (int j = 0; j < numsStr.length; j += 2) {
                long start = Integer.parseInt(numsStr[j]);
                long end = Integer.parseInt(numsStr[j + 1]);
                totalSum += sumRange(start, end);
            }

            System.out.println(totalSum);
        }
    }
}