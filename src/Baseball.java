import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baseball {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr51.dat"));
        int numLines = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        Pattern patternOutOf = Pattern.compile("(\\d+) out of (\\d+)");
        Pattern patternFor = Pattern.compile("(\\d+) for (\\d+)");

        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            Matcher matcherOutOf = patternOutOf.matcher(line);
            Matcher matcherFor = patternFor.matcher(line);

            if (matcherOutOf.find()) {
                int hits = Integer.parseInt(matcherOutOf.group(1));
                int atBats = Integer.parseInt(matcherOutOf.group(2));
                double average = (double) hits / atBats;
                String formattedAverage = String.format(" (%.3f)", average);
                line = line.replace(matcherOutOf.group(0), matcherOutOf.group(0) + formattedAverage);
            } else if (matcherFor.find()) {
                int hits = Integer.parseInt(matcherFor.group(1));
                int atBats = Integer.parseInt(matcherFor.group(2));
                double average = (double) hits / atBats;
                String formattedAverage = String.format(" (%.3f)", average);
                line = line.replace(matcherFor.group(0), matcherFor.group(0) + formattedAverage);
            }

            System.out.println(line);
        }

        scanner.close();
    }
}