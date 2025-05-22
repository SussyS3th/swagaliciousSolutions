import java.util.*;
import java.io.*;

public class GasMoney
{
    public static void print(String x) {
        System.out.println(x);
    }
    public static void main (String[] args) throws IOException
    {
        Scanner  scanner= new Scanner(new File("pr11.dat" ));
        int times = scanner.nextInt();
        scanner.nextLine();
        for (int zz = 0; zz < times; zz++ ) {
            double gal = scanner.nextDouble();
            double p1 = scanner.nextDouble();
            double p2 = scanner.nextDouble();
            double day1 = gal * p1;
            double day2 = gal * p2;
            if (day1 == day2) print("PAID THE SAME");
            else if (day1 > day2) print("PAID MORE: $" + String.format("%.2f " , day1 - day2));
            else if (day1 < day2) print("SAVED: $" + String.format("%.2f " , day2 - day1));
        }
    }
}