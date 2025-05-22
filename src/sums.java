import java.util.*;
import java.io.*;
public class sums {
    public static String sums(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr154.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            int[] nums = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                 nums[j] = Integer.parseInt(arr[j]);
            }
            System.out.println(sums(nums, target));
        }
    }
}
