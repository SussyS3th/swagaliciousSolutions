import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AlphaSplit {
    public static void Lprint(String x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr77.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            StringBuilder line1 = new StringBuilder();
            StringBuilder line2 = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
                        line1.append(c);
                        line2.append(' ');
                    } else if (c >= 'N' && c <= 'Z' || c >= 'n' && c <= 'z') {
                        line1.append(' ');
                        line2.append(c);
                    }
                } else {
                    line1.append(c);
                    line2.append(c);
                }
            }

            Lprint(line1.toString());
            Lprint(line2.toString());
            Lprint("");
        }
    }
}