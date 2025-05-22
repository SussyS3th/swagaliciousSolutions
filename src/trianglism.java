import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class trianglism {
    public static void Lprint(String x) {
        System.out.println(x);
    }
    public static void print(String x) {
        System.out.print(x);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr31.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            int size = scanner.nextInt();

            for (int j = size; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    print("*");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}