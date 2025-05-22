import java.time.DayOfWeek;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Wash {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("wash.dat"));

        while (sc.hasNextLine()) {
            String [] line = sc.nextLine().split("/");
            LocalDate date = LocalDate.of(Integer.parseInt(line[2]), Integer.parseInt(line[0]), Integer.parseInt(line[1]));

//            System.out.println(date);
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println("Good to GO");
            } else {
                System.out.println("Not a great idea you foolish insect");
            }
        }
    }
}