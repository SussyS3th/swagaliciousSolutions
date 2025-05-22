import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class charCounter {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("pr19.dat"));
        int num = scanner.nextInt();
        scanner.nextLine();
        String answer = "";

        for (int i = 0; i < num; i++) {
            answer = "";
            String str = scanner.nextLine();
            String str1 = str.replaceAll("[^A-Za-z]+", "");
            String str2 = str.replaceAll("\\D+", "");
            String str3 = str.replaceAll("[A-Za-z\\d]+", "");
            int numChars = str1.length();
            int numDigits = str2.length();
            int numOtherChars = str3.length();

            if(numChars >= 10) answer += ("LETTERS: " + numChars);
            else answer += ("LETTERS:  " + numChars);

            if (numDigits >= 10) answer += (" DIGITS: " + numDigits);
            else answer += (" DIGITS:  " + numDigits);

            if (numOtherChars >= 10) answer += (" OTHER: " + numOtherChars);
            else answer += (" OTHER:  " + numOtherChars);
            System.out.println(answer);
        }
    }
}