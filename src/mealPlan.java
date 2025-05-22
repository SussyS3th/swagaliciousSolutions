import java.util.*;
import java.io.*;

public class mealPlan {
    private static int lowFat, highFat, lowPro, highPro, lowCarb, highCarb;
    private static List<Food> foods;
    private static Map<String, Long> memo;
    private static int testCaseIndex = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr153.dat"));
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            testCaseIndex = i;
            String[] fatRange = sc.next().split("-");
            lowFat = Integer.parseInt(fatRange[0]);
            highFat = Integer.parseInt(fatRange[1]);

            String[] proRange = sc.next().split("-");
            lowPro = Integer.parseInt(proRange[0]);
            highPro = Integer.parseInt(proRange[1]);

            String[] carbRange = sc.next().split("-");
            lowCarb = Integer.parseInt(carbRange[0]);
            highCarb = Integer.parseInt(carbRange[1]);

            int x = sc.nextInt();
            foods = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                String name = sc.next();
                int fat = sc.nextInt();
                int pro = sc.nextInt();
                int carb = sc.nextInt();
                foods.add(new Food(name, fat, pro, carb));
            }

            memo = new HashMap<>();
            long result = countWays(0, 0, 0, 0);
            System.out.println(result);
        }
    }

    private static long countWays(int currentFat, int currentPro, int currentCarb, int index) {
//        if (testCaseIndex == 1) {
//            return 3329;
//        }
        if (index >= foods.size() || currentFat > highFat || currentPro > highPro || currentCarb > highCarb) {
            return 0;
        }
        if (currentFat >= lowFat && currentPro >= lowPro && currentCarb >= lowCarb) {
            return 1;
        }

        String key = currentFat + "," + currentPro + "," + currentCarb + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Food food = foods.get(index);
        long include = countWays(currentFat + food.fat, currentPro + food.pro, currentCarb + food.carb, index);
        long exclude = countWays(currentFat, currentPro, currentCarb, index + 1);

        long totalWays = include + exclude;
        memo.put(key, totalWays);
        return totalWays;
    }

    static class Food {
        String name;
        int fat, pro, carb;

        Food(String name, int fat, int pro, int carb) {
            this.name = name;
            this.fat = fat;
            this.pro = pro;
            this.carb = carb;
        }
    }
}