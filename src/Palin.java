import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Palin {
    public static void Lprint(String x) {
        System.out.println(x);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr71.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            String str = scanner.nextLine();
            boolean isPalindrome = true;
            String strNoSpaces = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int length = strNoSpaces.length();
            for (int k = 0; k < length / 2; k++) {
                if (strNoSpaces.charAt(k) != strNoSpaces.charAt(length - k - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                Lprint("PALINDROME");
            } else {
                Lprint("NOT PALINDROME");
            }
        }
    }
}