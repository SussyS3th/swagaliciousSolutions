import java.util.*;
import java.io.*;

public class Stocks {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("stocks.dat"));
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCases; i++) {
            String[] nums = scanner.nextLine().split(" ");
            List<Integer> stocks = new ArrayList<>();
            for (String num : nums) stocks.add(Integer.parseInt(num));

            List<String> transactions = new ArrayList<>();
            for (int j = 0; j < stocks.size() - 1; j++) {
                while (j < stocks.size() - 1 && stocks.get(j) >= stocks.get(j + 1)) j++;
                if (j == stocks.size() - 1) break;
                int buy = j;
                while (j < stocks.size() - 1 && stocks.get(j) <= stocks.get(j + 1)) j++;
                int sell = j;
                transactions.add(buy + " -> " + sell);
            }

            for (String transaction : transactions) System.out.println(transaction);
            if (i < numCases - 1) System.out.println();
        }
    }
}