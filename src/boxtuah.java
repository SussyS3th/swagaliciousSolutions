import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class boxtuah {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("box.dat"));
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // top border
            for (int j = 0; j < b; j++) {
                System.out.print("-");
            }
            System.out.println();

            // middle rows
            for (int j = 0; j < a - 2; j++) {
                System.out.print("|");
                for (int k = 0; k < b - 2; k++) {
                    System.out.print(" ");
                }
                System.out.println("|");
            }

            // bottom border
            for (int j = 0; j < b; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}