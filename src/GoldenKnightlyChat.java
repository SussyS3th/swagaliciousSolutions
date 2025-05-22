import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.LocalTime;

public class GoldenKnightlyChat {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("evoKnight.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i ++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime duskGMT = LocalTime.parse(sc.nextLine(), formatter);
            LocalTime dawnGMT = LocalTime.parse(sc.nextLine(), formatter);

            HashMap<String, LocalTime> friendsDusk = new HashMap<>();
            HashMap<String, LocalTime> friendsDawn = new HashMap<>();

            friendsDusk.put("Madrid", duskGMT.minusHours(1));
            friendsDusk.put("Moscow", duskGMT.plusHours(3));
            friendsDusk.put("Tokyo", duskGMT.plusHours(9));

            friendsDawn.put("Madrid", dawnGMT.minusHours(1));
            friendsDawn.put("Moscow", dawnGMT.plusHours(3));
            friendsDawn.put("Tokyo", dawnGMT.plusHours(9));

            System.out.println("Case " + (i + 1) + ":");
            System.out.println();

            HashMap<String, Integer> duskMinutes = new HashMap<>();
            HashMap<String, Integer> dawnMinutes = new HashMap<>();

            duskMinutes.put("Madrid", convertToMinutes(friendsDusk.get("Madrid")));
            duskMinutes.put("Moscow", convertToMinutes(friendsDusk.get("Moscow")));
            duskMinutes.put("Tokyo", convertToMinutes(friendsDusk.get("Tokyo")));

            dawnMinutes.put("Madrid", convertToMinutes(friendsDawn.get("Madrid")));
            dawnMinutes.put("Moscow", convertToMinutes(friendsDawn.get("Moscow")));
            dawnMinutes.put("Tokyo", convertToMinutes(friendsDawn.get("Tokyo")));

            // Output the time windows in minutes
            System.out.println("Madrid: " + duskMinutes.get("Madrid") + " minutes" + " to " + dawnMinutes.get("Madrid") + " minutes");
            System.out.println("Moscow: " + duskMinutes.get("Moscow") + " minutes" + " to " + dawnMinutes.get("Moscow") + " minutes");
            System.out.println("Tokyo: " + duskMinutes.get("Tokyo") + " minutes" + " to " + dawnMinutes.get("Tokyo") + " minutes");

            int startWindow = duskMinutes.get("Madrid");
            int endWindow = dawnMinutes.get("Tokyo");

            if (startWindow < endWindow) {
                LocalTime startTime = convertToLocalTime(startWindow);
                LocalTime endTime = convertToLocalTime(endWindow);
                System.out.println("Friends can call between " + startTime.format(formatter) + " and " + endTime.format(formatter) + " GMT");
            } else {
                System.out.println("CANNOT FIND A SLOT");
            }
        }
    }

    private static int convertToMinutes(LocalTime time) {
        return time.getHour() * 60 + time.getMinute();
    }

    private static LocalTime convertToLocalTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return LocalTime.of(hours, mins);
    }
}