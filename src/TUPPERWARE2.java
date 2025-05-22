import java.util.*;
import java.io.*;

public class TUPPERWARE2 {

    public static String check(int[] a, int h) {
        Set<Integer> possibleSums = new HashSet<>();
        generateSums(a, 0, 0, possibleSums);

        if (possibleSums.contains(h)) {
            return "ESCAPABLE";
        } else {
            return "STUCK FOREVER";
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
        Scanner sc = new Scanner(new File("tupperware.dat"));
        int height = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 5; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            for (int j = 0; j < arr.length; j++) {
                total += arr[j];
            }

            String result = check(arr, height);
            System.out.println(result);
        }
    }
}