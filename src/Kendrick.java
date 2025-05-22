import java.util.*;
import java.io.*;

public class Kendrick {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dna.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String strand = sc.nextLine();
            Set<String> seen = new HashSet<>();
            Set<String> repeated = new TreeSet<>();

            for (int j = 0; j <= strand.length() - 10; j++) {
                String sequence = strand.substring(j, j + 10);
                if (seen.contains(sequence)) {
                    repeated.add(sequence);
                } else {
                    seen.add(sequence);
                }
            }

            System.out.println(repeated);
        }
    }
}