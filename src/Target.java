import java.io.*;
import java.util.*;

public class Target {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("target.dat"));
        int n = sc.nextInt();
        while (n-- > 0) {
            int target = sc.nextInt();
            int[][] arr = new int[target][target];
            for (int layer = 0; layer < (target + 1) / 2; layer++)
                for (int i = layer; i < target - layer; i++)
                    for (int j = layer; j < target - layer; j++)
                        arr[i][j] = layer + 1;
            for (int[] row : arr) {
                for (int num : row) System.out.print(num);
                System.out.println();
            }
        }
    }
}