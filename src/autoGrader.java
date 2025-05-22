import java.util.*;
import java.io.*;

public class autoGrader {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr170.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int grade = sc.nextInt();
            if (grade < 60) {
                System.out.println(grade);
            }
            else {
                while (grade% 5 != 0) {
                    grade++;
                }
                System.out.println(grade);
            }
        }
    }
}
