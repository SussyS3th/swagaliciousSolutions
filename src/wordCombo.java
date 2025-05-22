import java.util. *;
import java.io. *;

public class wordCombo {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr151.dat"));
        int numCombos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCombos; i++) {
            String word = scanner.nextLine().trim();
            List<String> combinations = generateCombinations(word);
            Collections.sort(combinations);

            for (String combination : combinations) {
                System.out.println(combination);
            }

            System.out.println();
        }
    }
    private static List<String> generateCombinations(String word) {
        List<String> result = new ArrayList<>();
        int length = word.length();
        int totalCombinations = 1 << length;

        for (int i = 1; i < totalCombinations; i++) {
            StringBuilder combination = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) > 0) {
                    combination.append(word.charAt(j));
                }
            }
            result.add(combination.toString());
        }
        return result;
    }
}