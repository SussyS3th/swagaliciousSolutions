import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Palindrome {
    public static void print(String x) {
        System.out.println(x);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr72.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            String str = scanner.nextLine();
            StringBuilder input1 = new StringBuilder(str);
            StringBuilder s = input1.reverse();

            String pal = str;

            if (isPalindrome(str)) print(str);
            else {
                for (int j = 0; j < str.length(); j++) {
                    String temp = str.substring(0, j + 1) + s.toString();
                    if (isPalindrome(temp)) {
                        pal = temp;
                        break;
                    }
                }
                System.out.println(pal);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}