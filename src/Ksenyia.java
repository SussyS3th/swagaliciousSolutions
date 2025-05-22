import java.util.*;
import java.io.*;

public class Ksenyia {
    public static boolean dups(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            if (charCount.get(c) >= 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ksenyia.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        List<String> users = new ArrayList<>();
        List<String> passes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String user = sc.nextLine();
            String pass = sc.nextLine();

            boolean uCheck = (user.length() < 20 && user.length() > 6) && (Character.isUpperCase(user.charAt(0))) && (user.matches("[a-zA-Z0-9]+"));
            boolean passCheck = (pass.matches(".*[a-zA-Z0-9].*") && pass.matches(".*[!@#$%^&*()_+].*")) && (pass.length() < 30 && pass.length() > 10) && !pass.contains(" ") && (dups(pass));

            if (users.contains(user) && passes.contains(pass)) {
                uCheck = false;
                passCheck = false;
            } else {
                users.add(user);
                passes.add(pass);
            }

            if (uCheck && passCheck) System.out.println("Valid");
            else if (!uCheck && passCheck) System.out.println("Username Invalid");
            else if (uCheck && !passCheck) System.out.println("Password Invalid");
            else System.out.println("Both Invalid");
        }
    }
}
