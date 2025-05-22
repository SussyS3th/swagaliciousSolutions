import java.io.*;
import java.util.*;

public class stats {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("stats.dat"));
        int numberOfLines = sc.nextInt();
        sc.nextLine(); // Move to the next line

        for (int i = 0; i < numberOfLines; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue; // Skip empty lines
            }
            String[] numbers = line.split("\\s+");
            List<Integer> list = new ArrayList<>();
            for (String number : numbers) {
                if (!number.isEmpty()) {
                    list.add(Integer.parseInt(number));
                }
            }

            double median = calculateMedian(list);
            double average = calculateAverage(list);
            double difference = Math.abs(median - average);

            System.out.printf("%.2f%n", difference);
        }
    }

    private static double calculateMedian(List<Integer> list) {
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        } else {
            return list.get(size / 2);
        }
    }

    private static double calculateAverage(List<Integer> list) {
        double sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum / list.size();
    }
}