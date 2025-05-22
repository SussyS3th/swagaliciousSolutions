import java.util.*;
import java.io.*;

public class Missions {
    static Map<String, List<String>> heroes = new HashMap<>();
    static List<String> heroNames = new ArrayList<>();
    static Set<List<String>> results = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("missions.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        heroes.put("Colossus", Arrays.asList("Strength", "Invulnerability"));
        heroes.put("Wolverine", Arrays.asList("Hand-to-Hand", "Invulnerability"));
        heroes.put("Nightcrawler", Arrays.asList("Teleportation", "Swords", "Hand-to-Hand", "Agility"));
        heroes.put("Storm", Arrays.asList("Flight", "Electric", "Cold"));
        heroes.put("Banshee", Arrays.asList("Flight", "Energy-Blasts"));
        heroes.put("Cyclops", Arrays.asList("Hand-to-Hand", "Energy-Blasts"));
        heroes.put("Phoenix", Arrays.asList("Flight", "Telekinesis", "Telepathy", "Energy-Blasts"));
        heroes.put("Iceman", Arrays.asList("Cold", "Invulnerability"));
        heroes.put("Beast", Arrays.asList("Strength", "Agility"));
        heroes.put("Angel", Arrays.asList("Flight", "Swords"));

        heroNames.addAll(heroes.keySet());
        Collections.sort(heroNames);

        while (n-- > 0) {
            String[] skills = sc.nextLine().split(" ");
            results.clear();
            findCombinations(new ArrayList<>(), new HashSet<>(), skills, 0);

            if (results.isEmpty()) {
                System.out.println("0\n");
            } else {
//                System.out.println(results.size());
                // System.out.println(results.size());
                List<List<String>> sortedResults = new ArrayList<>(results);
                sortedResults.sort(Comparator.comparing(a -> String.join(" ", a)));
                String ans = String.join(" ", sortedResults.getFirst());
                Set<List<String>> set = new HashSet<>();
                for(List<String> k: results) {
                    Collections.sort(k);
                    set.add(k);
                }
                System.out.println(set.size());
                System.out.println(ans);
            }
        }
    }

    static void findCombinations(List<String> current, Set<String> usedHeroes, String[] skills, int index) {
        if (index == skills.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        String skill = skills[index];
        for (String hero : heroNames) {
            if (!usedHeroes.contains(hero) && heroes.get(hero).contains(skill)) {
                current.add(hero);
                usedHeroes.add(hero);
                findCombinations(current, usedHeroes, skills, index + 1);
                current.removeLast();
                usedHeroes.remove(hero);
            }
        }
    }
}