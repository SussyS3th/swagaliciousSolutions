import java.util.*;
import java.io.*;

public class ParenthesesBalance {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr86.dat"));
        int numLines = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numLines; i++) {
            String line = sc.nextLine();
            int totalOpen = 0;
            int totalClose = 0;

            // Count total open and close parentheses
            for (char c : line.toCharArray()) {
                if (c == '(') {
                    totalOpen++;
                } else if (c == ')') {
                    totalClose++;
                }
            }

            int openCount = 0;
            int closeCount = totalClose;

            // Find the index with equal open before and close after
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '(') {
                    openCount++;
                } else if (line.charAt(j) == ')') {
                    closeCount--;
                }

                if (openCount == closeCount) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}