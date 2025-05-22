import java.util.*;
import java.io.*;

public class News {
    public static String Magneto = "Magneto";
    public static String Juggernaut = "Juggernaut";
    public static String Apocalypse = "Apocalypse";
    public static String Mystique = "Mystique";
    public static String Sentinels = "Sentinels";

    public static String Thanos = "Thanos";
    public static String Galactus = "Galactus";
    public static String Kang = "Kang";
    public static String Ultron = "Ultron";
    public static String Graviton = "Graviton";

    public static void check(String s) {
         if (s.contains(Thanos) || s.contains(Galactus) || s.contains(Kang) || s.contains(Ultron) || s.contains(Graviton)) System.out.println("Calling All Heroes.");
         else if (s.contains(Magneto) || s.contains(Juggernaut) || s.contains(Apocalypse) || s.contains(Mystique) || s.contains(Sentinels)) System.out.println("Sharpen Your Claws Wolverine.");
        else System.out.println("Business as Usual.");

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("news.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            check(line);
        }
    }
}