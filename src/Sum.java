import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Sum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            int sum = 0;
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            System.out.println("SUM = " + sum);
        }

    }
}
