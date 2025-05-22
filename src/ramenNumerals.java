import java.util.*;
import java.io.*;

public class ramenNumerals {

    private static Map<Character, Integer> romanToIntMap = new HashMap<>();

    static {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
    }
    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanToIntMap.get(s.charAt(i));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr82.dat"));
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String roman = scanner.nextLine();
            System.out.println(romanToInt(roman));
        }
        }
    }

