import java.util.*;
import java.io.*;

public class Cyclops {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("cyclops.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int p = sc.nextInt();
            sc.nextLine();

            int totalPowerRequired = 0;
            int[][] wall = new int[r][c];

            for (int i = 0; i < r; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < c; j++) {
                    wall[i][j] = line.charAt(j) - '0';
                    totalPowerRequired += wall[i][j];
                }
            }

            int halfPowerRequired = (totalPowerRequired + 1) / 2;

            if (p >= halfPowerRequired) {
                int remainingPower = p - halfPowerRequired;
                System.out.println("Made it with " + remainingPower + " power to spare.");
            } else {
                System.out.println("Better Call Iceman.");
            }
        }
    }
}