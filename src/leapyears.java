import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class leapyears {
    public static void print(String x) {
        System.out.println(x);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr26.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            int year = scanner.nextInt();
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) print(year +" IS A LEAP YEAR!");
            else print(year + " IS NOT A LEAP YEAR!");
        }

    }
}