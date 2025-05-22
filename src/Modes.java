import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Modes {
    public static void main(String[]args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr50.dat"));
        int n = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            int arr[] = new int[tokens.length];
            for (int j = 0; j < tokens.length; j++) {
                arr[j] = Integer.parseInt(tokens[j]);
            }

            System.out.println(getModes(arr));

        }
    }

    public static String getModes(int[] arr) {
        int[] freq = new int[101];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
            }
        }

        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == max) {
                count++;
            }
        }

        if (count == 1) {
            return "1 MODE";
        } else {
            return count + " MODES";
        }
    }
}
