import java.util.*;
import java.io.*;

public class Cerbero {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("cerbero.dat"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String person1 = sc.next();
            String person2 = sc.next();
            sc.nextLine();

            graph.putIfAbsent(person1, new ArrayList<>());
            graph.get(person1).add(person2);
        }

        List<String> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queries.add(sc.nextLine());
        }

        for (String query : queries) {
            if (isConnected(graph, "Xavier", query)) {
                System.out.println("Mutant Located.");
            } else {
                System.out.println("Nowhere to be found.");
            }
        }
    }

    private static boolean isConnected(Map<String, List<String>> graph, String start, String target) {
        if (start.equals(target)) {
            return true;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            List<String> neighbors = graph.getOrDefault(current, Collections.emptyList());

            for (String neighbor : neighbors) {
                if (neighbor.equals(target)) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}