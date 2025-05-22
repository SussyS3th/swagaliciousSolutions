import java.util.*;
import java.io.*;

public class Mother {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("mother.dat"));
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(simulateSentinels(n));
        }
    }

    public static int simulateSentinels(int n) {
        List<Integer> masterMolds = new ArrayList<>();
        int sentinels = 0;

        for (int cycle = 1; cycle <= n; cycle++) {
            // Update the state of each Master Mold
            for (int j = 0; j < masterMolds.size(); j++) {
                int state = masterMolds.get(j);
                if (state == 0) {
                    masterMolds.set(j, 1); // Creating another Master Mold
                } else if (state == 1) {
                    masterMolds.set(j, 2); // Recuperating
                } else {
                    masterMolds.set(j, 3); // Creating Sentinels
                    sentinels++;
                }
            }

            // Add a new Master Mold created by the Mother Mold
            masterMolds.add(0);
        }

        return sentinels;
    }
}