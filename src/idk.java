import java.util.*;
import java.io.*;

public class idk {
    public static int[] convertToBase28(char[] chars) {
        int[] base28Values = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int asciiValue = (int) chars[i];
            base28Values[i] = convertToBase28(asciiValue);
        }
        return base28Values;
    }

    private static int convertToBase28(int value) {
        int base = 28;
        int result = 0;
        int multiplier = 1;
        while (value > 0) {
            int remainder = value % base;
            result += remainder * multiplier;
            value /= base;
            multiplier *= 10;
        }
        return result;
    }

    public static int convertSumToBase28(int sum) {
        return convertToBase28(sum);
    }

    public static void main (String [] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("idk.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            List<Character> letters = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();

            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    letters.add(ch);
                } else if (Character.isDigit(ch)) {
                    numbers.add(Character.getNumericValue(ch));
                }
            }

            char[] let = new char[letters.size()];
            for (int j = 0; j < letters.size(); j++) {
                let[j] = letters.get(j);
            }

            int[] num = new int[numbers.size()];
            for (int j = 0; j < numbers.size(); j++) {
                num[j] = numbers.get(j);
            }

            System.out.println("Letters: " + Arrays.toString(let));
            System.out.println("Numbers: " + Arrays.toString(num));
            System.out.println();
            int[] base28Values = convertToBase28(let);
            System.out.println("Base 28 values: " + Arrays.toString(base28Values));
            System.out.println();
            for (int j = 0; j < base28Values.length; j++) {
                sum += base28Values[j];
            }
            System.out.println("Sum: " + sum);

            int sumBase28 = convertSumToBase28(sum);
            System.out.println("Sum in base 28: " + sumBase28);
        }
    }
}