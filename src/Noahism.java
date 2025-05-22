import java.util.*;
import java.io.*;

public class Noahism {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("noah.dat"));
        ArrayList<String> cars = new ArrayList<>();

        int numLines = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numLines; i++) {
            String str = scanner.nextLine();
            String[] parts = str.split(",");
            String car = parts[0] + " " + parts[1] + " " + parts[2];
            cars.add(car);
        }
        Comparator<String> comp = (a, b) -> a.compareTo(b);
        cars.sort(comp);

        System.out.println("---Data Sorted---");
        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println("\n---Make Breakdown---");

        int chevy = 0;
        int dodge = 0;
        int ford = 0;

        int chal = 0;
        int charger = 0;
        int cruze = 0;
        int durango = 0;
        int edge = 0;
        int explorer = 0;
        int f150 = 0;
        int mustang = 0;
        int ram1500 = 0;
        int silverado = 0;

        int y2006 = 0;
        int y2008 = 0;
        int y2009 = 0;
        int y2010 = 0;
        int y2012 = 0;
        int y2015 = 0;
        int y2017 = 0;
        int y2018 = 0;
        int y2019 = 0;
        int y2020 = 0;

        for (String car : cars) {
            String[] parts = car.split(" ");
            String make = parts[0];
            String model = parts[1];
            String year = parts[2];

            // Make counting
            if (make.equals("Chevy")) chevy++;
            else if (make.equals("Dodge")) dodge++;
            else if (make.equals("Ford")) ford++;

            // Model counting
            if (model.equals("Challenger")) chal++;
            else if (model.equals("Charger")) charger++;
            else if (model.equals("Cruze")) cruze++;
            else if (model.equals("Durango")) durango++;
            else if (model.equals("Edge")) edge++;
            else if (model.equals("Explorer")) explorer++;
            else if (model.equals("F150")) f150++;
            else if (model.equals("Mustang")) mustang++;
            else if (model.equals("Ram1500")) ram1500++;
            else if (model.equals("Silverado")) silverado++;

            // Year counting
            if (year.equals("2006")) y2006++;
            else if (year.equals("2008")) y2008++;
            else if (year.equals("2009")) y2009++;
            else if (year.equals("2010")) y2010++;
            else if (year.equals("2012")) y2012++;
            else if (year.equals("2015")) y2015++;
            else if (year.equals("2017")) y2017++;
            else if (year.equals("2018")) y2018++;
            else if (year.equals("2019")) y2019++;
            else if (year.equals("2020")) y2020++;
        }

        System.out.println("Chevy: " + chevy);
        System.out.println("Dodge: " + dodge);
        System.out.println("Ford: " + ford);

        System.out.println("\n---Model Breakdown---");
        System.out.println("Challenger: " + chal);
        System.out.println("Charger: " + charger);
        System.out.println("Cruze: " + cruze);
        System.out.println("Durango: " + durango);
        System.out.println("Edge: " + edge);
        System.out.println("Explorer: " + explorer);
        System.out.println("F150: " + f150);
        System.out.println("Mustang: " + mustang);
        System.out.println("Ram1500: " + ram1500);
        System.out.println("Silverado: " + silverado);

        System.out.println("\n---Year Breakdown---");
        System.out.println("2006: " + y2006);
        System.out.println("2008: " + y2008);
        System.out.println("2009: " + y2009);
        System.out.println("2010: " + y2010);
        System.out.println("2012: " + y2012);
        System.out.println("2015: " + y2015);
        System.out.println("2017: " + y2017);
        System.out.println("2018: " + y2018);
        System.out.println("2019: " + y2019);
        System.out.println("2020: " + y2020);
    }
}