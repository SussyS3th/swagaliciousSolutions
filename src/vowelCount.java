import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class vowelCount{
    public static void main(String[]args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr26.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            int count = 1;
            for(int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    System.out.print(count);
                    count++;
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}