import java.util.*;
import java.io.*;

public class hotChocolate {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("chocolates.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>(); // chocolate
            String[] line = sc.nextLine().split(" ");
            for (String s : line) {
                arr.add(Integer.parseInt(s));
            }
            Integer student = arr.getFirst();
            arr.removeFirst();
            Collections.sort(arr);
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < arr.size() - student + 1; j++) {
                int diff = arr.get(j + student - 1) - arr.get(j);
                if (diff < min) {
                    min = diff;
                }
            }
            System.out.println(min);
        }
    }
}
