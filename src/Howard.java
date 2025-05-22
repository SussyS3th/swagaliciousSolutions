import java.util.*;
import java.io.*;

public class Howard {
    public static class player {
        int number;
        String name;
        String position;
        float pts;
        float apg;
        float fga;
        float fta;
        float tpg;
        float ts;

        public player(int number, String name, String position, float pts, float apg, float fga, float fta, float tpg, float ts) {
            this.number = number;
            this.name = name;
            this.position = position;
            this.pts = pts;
            this.apg = apg;
            this.fga = fga;
            this.fta = fta;
            this.tpg = tpg;
            this.ts = ts;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("howard.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(" ");
            player p = new player(
                    Integer.parseInt(arr[0]), arr[1], arr[2], Float.parseFloat(arr[3]),
                    Float.parseFloat(arr[4]), Float.parseFloat(arr[5]), Float.parseFloat(arr[6]),
                    Float.parseFloat(arr[7]), (float)(Float.parseFloat(arr[3]) / (2 * Float.parseFloat(arr[5]) + 0.44 * Float.parseFloat(arr[6])))
            );
            players.add(p);
        }

        Map<String, player> highestTsByPosition = new HashMap<>();
        for (player p : players) {
            highestTsByPosition.merge(p.position, p, (existing, newPlayer) -> newPlayer.ts > existing.ts ? newPlayer : existing);
        }

        List<player> highestTsPlayers = new ArrayList<>(highestTsByPosition.values());
        highestTsPlayers.sort(Comparator.comparingInt(a -> a.number));

        for (player p : highestTsPlayers) {
            System.out.printf("%s: %d. %s%n", p.position, p.number, p.name);
        }
    }
}