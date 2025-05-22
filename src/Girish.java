import java.io.*;
import java.util.*;

public class Girish {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("girish.dat"));
        List<double[]> allLists = new ArrayList<>();
        List<Double> uniqueNums = new ArrayList<>();
        List<Integer> frequencies = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(" ");
            double[] nums = new double[arr.length];
            for (int j = 0; j < arr.length; j++) {
                nums[j] = Double.parseDouble(arr[j]);
            }
            allLists.add(nums);

            for (double num : nums) {
                int index = uniqueNums.indexOf(num);
                if (index == -1) {
                    uniqueNums.add(num);
                    frequencies.add(1);
                } else {
                    frequencies.set(index, frequencies.get(index) + 1);
                }
            }
        }

        List<Double> medians = new ArrayList<>();
        for (double[] nums : allLists) {
            Arrays.sort(nums);
            int median;
            if (nums.length % 2 == 0) {
                median = (int) ((nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2);
            } else {
                median = (int) nums[nums.length / 2];
            }
            medians.add((double) median);
        }
        double medianMean = 0;
        for (double median : medians) {
            medianMean += median;
        }
        medianMean /= medians.size();

        double totalSum = 0;
        int totalCount = 0;
        for (double[] nums : allLists) {
            for (double num : nums) {
                totalSum += num;
                totalCount++;
            }
        }
        double meanSum = (int) (totalSum / totalCount);

        double modeKinda = 0;
        int maxFrequency = 0;
        for (int i = 0; i < uniqueNums.size(); i++) {
            if (frequencies.get(i) > maxFrequency && frequencies.get(i) < allLists.size()) {
                maxFrequency = frequencies.get(i);
                modeKinda = uniqueNums.get(i);
            }
        }

        System.out.printf("Median Mean: %.2f%n", medianMean);
        System.out.printf("Mean Sum: %.2f%n", meanSum);
        System.out.printf("Mode Kinda: %.0f%n", modeKinda);
    }
}