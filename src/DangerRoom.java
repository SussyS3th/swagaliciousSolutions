import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

public class DangerRoom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("danger.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        List<Map.Entry<LocalTime, String>> entries = new ArrayList<>();
        DateTimeFormatter militaryFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter regularFormatter = DateTimeFormatter.ofPattern("K:mm ");

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            LocalTime time = LocalTime.parse(parts[0], militaryFormatter);
            String name = parts[1];
            entries.add(new AbstractMap.SimpleEntry<>(time, name));
        }

        entries.sort(Map.Entry.comparingByKey());

        for (Map.Entry<LocalTime, String> entry : entries) {
            System.out.println(entry.getKey().format(regularFormatter) + " " + entry.getValue());
        }
    }
}