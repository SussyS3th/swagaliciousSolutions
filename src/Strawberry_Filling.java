import java.util.*;
import java.io.*;

public class Strawberry_Filling {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("blanks.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            List<Integer> numbers = new ArrayList<>();

            for (String part : parts) {
                numbers.add(Integer.parseInt(part));
            }

            Collections.sort(numbers);
            List<Integer> result = new ArrayList<>();

            for (int j = 0; j < numbers.size() - 1; j++) {
                for (int k = numbers.get(j) + 1; k < numbers.get(j + 1); k++) {
                    result.add(k);
                }
            }

            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}