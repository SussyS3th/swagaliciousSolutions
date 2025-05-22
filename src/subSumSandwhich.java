import java.util. *;
import java.io. *;

public class subSumSandwhich {
    public static void main (String [] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sumSub.dat"));
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCases; i++) {
            Integer target = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] nums = line.split(" ");

            for (int j = 0; j < nums.length; j++) {
                if (Integer.parseInt(nums[j]) == target) System.out.println(j);
                else {
                    int sum = target;
                    sum -= Integer.parseInt(nums[j]);
                    for (int k = j + 1; k < nums.length; k++) {
                        sum -= Integer.parseInt(nums[k]);
                        if (sum == 0) {
                            System.out.println(j + " " + k);
                            break;
                        }
                        else continue;
                    }
                }
            }


        }
    }
}
