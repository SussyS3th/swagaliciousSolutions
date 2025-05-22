import java.util.*;
import java.io.*;

public class sums3 {

    public static String check(int[] a, int h) {
        Set<Integer> possibleSums = new HashSet<>();
        generateSums(a, 0, 0, possibleSums);

        if (possibleSums.contains(h)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static void generateSums(int[] a, int index, int currentSum, Set<Integer> possibleSums) {
        if (index == a.length) {
            possibleSums.add(currentSum);
            return;
        }
        generateSums(a, index + 1, currentSum, possibleSums);
        generateSums(a, index + 1, currentSum + a[index], possibleSums);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr154.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            int[] arr = Arrays.stream(sc.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            String result = check(arr, height);
            System.out.println(result);
        }
    }
}