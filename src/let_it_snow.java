import java.util.*;
import  java.io.*;
public class let_it_snow {
    public static void printSpaces(int n) {
        String spaces = "";
        for (int i = 0; i < n; i++) {
            spaces += " ";
        }
        System.out.print(spaces);
    }

    public static void main (String[] args) throws  FileNotFoundException  {
        Scanner sc = new Scanner(new File("pr37.dat"));
        int val = 0; // number for snowflake
        int count = 0;

        //print top of snowflake
        for (int a = 0; a < 4; a++) {
            val = sc.nextInt();
            if (val == 1) {
                System.out.println("111\n111\n111");
                System.out.println();
                continue;
            }
            if (val == 2) {
                System.out.println("2 2 2\n 222\n22222\n 222\n2 2 2");
                continue;
            }
            for (int i = val-1; i >= 0; i--) {
                printSpaces(count);
                System.out.print(val);
                printSpaces(i);
                System.out.print(val);
                printSpaces(i);
                System.out.print(val);
                printSpaces(i);
                System.out.println();
                count++;
            }

            for (int p = 0; p <= val * 2; ++p) {
                System.out.print(val);
            }
            System.out.println();


            //print bottom of snowflake
            for (int k = 0; k <= val - 1; k++) {
                printSpaces(--count);
                System.out.print(val);
                printSpaces(k);
                System.out.print(val);
                printSpaces(k);
                System.out.print(val);
                printSpaces(k);
                System.out.println();
            }
            System.out.println();
        }

    }
}
