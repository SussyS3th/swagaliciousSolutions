import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Justified {
    public static void Lprint(String x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr76.dat"));
        StringBuilder str = new StringBuilder();

        while (scanner.hasNextLine()) {
            str.append(scanner.nextLine()).append(" ");
        }
        scanner.close();

        String paragraph = str.toString().trim();
        String[] words = paragraph.split(" ");
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() + 1 > 40) {
                lines.add(line.toString());
                line = new StringBuilder();
            }
            if (line.length() > 0) {
                line.append(" ");
            }
            line.append(word);
        }

        if (line.length() > 0) {
            lines.add(line.toString());
        }

        Lprint("1234567890123456789012345678901234567890");

        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            if (i == lines.size() - 1) {
                Lprint(leftJustifyLine(currentLine, 40));
            } else {
                Lprint(justifyLine(currentLine, 40));
            }
        }
    }

    public static String justifyLine(String line, int length) {
        String[] words = line.split(" ");
        int totalSpaces = length - line.length();
        int gaps = words.length - 1;

        if (gaps == 0) {
            return line;
        }

        int spacesPerGap = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder justifiedLine = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            justifiedLine.append(words[i]);
            if (i < gaps) {
                for (int j = 0; j < spacesPerGap; j++) {
                    justifiedLine.append(" ");
                }
                if (i < extraSpaces) {
                    justifiedLine.append(" ");
                }
                justifiedLine.append(" "); // Add an extra space
            }
        }

        return justifiedLine.toString();
    }

    public static String leftJustifyLine(String line, int length) {
        String[] words = line.split(" ");
        StringBuilder leftJustifiedLine = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            leftJustifiedLine.append(words[i]);
            if (i < words.length - 1) {
                leftJustifiedLine.append(" ");
            }
        }
        return leftJustifiedLine.toString();
    }
}