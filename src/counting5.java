import java.math.*;
import java.util.*;
import java.io.*;

public class counting5 {
    public static int countFives(int number) {
        String numberStr = String.valueOf(number);
        int count = 0;
        for (char c : numberStr.toCharArray()) {
            if (c == '5') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("sect.dat"));

        while (sc.hasNext()) {
            int n = sc.nextInt();

            int count = 0;
            for (int i = 0; i <= n; i++) {
                count += countFives(i);
            }
            System.out.println(count);
        }
    }
}