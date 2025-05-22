import java.util.*;
import java.io.*;

public class PossibleGroup {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr152.dat"));
        int n = sc.nextInt();
        sc.nextLine(); // Move to the next line

        for (int i = 0; i < n; i++) {
            int numStudents = sc.nextInt();
            sc.nextLine();
            List<String> students = new ArrayList<>();
            for (int j = 0; j < numStudents; j++) {
                students.add(sc.nextLine());
            }
            int numGroups = calculateCombinations(numStudents, 3);
            System.out.println(numGroups);
        }
    }

    private static int calculateCombinations(int n, int r) {
        if (n < r) {
            return 0;
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
