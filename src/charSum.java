import java.util.*;
import java.io.*;

public class charSum {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("charSum.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        HashMap <Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().replaceAll(" ", "").toUpperCase();
            String lines = line.replaceAll("[^a-zA-Z]", "");
            char[] arr = lines.toCharArray();
            int sum = 0;
            for (char c : arr) {
                sum += map.get(c);
            }
            System.out.println(sum);
        }
    }
}