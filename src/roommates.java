import java.util.*;
import java.io.*;

public class roommates {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr155.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        boolean canFillRooms = false;

        for (int i = 0; i < n; i++) {
            int ppl = sc.nextInt();
            sc.nextLine();
            List<Person> people = new ArrayList<>();

            for (int j = 0; j < ppl; j++) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                Set<String> categories = new HashSet<>(Arrays.asList(parts).subList(1, parts.length));
                people.add(new Person(name, categories));
            }


            for (int j = 0; j < ppl - 1; j += 2) {
                canFillRooms =  hasCommonCategory(people.get(j), people.get(j + 1));
                break;
            }

            if (canFillRooms) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean hasCommonCategory(Person p1, Person p2) {
        for (String cat : p1.categories) {
            if (p2.categories.contains(cat)) {
                return true;
            }
        }
        return false;
    }

    static class Person {
        String name;
        Set<String> categories;

        Person(String name, Set<String> categories) {
            this.name = name;
            this.categories = categories;
        }
    }
}