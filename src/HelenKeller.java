import java.util.*;
import java.io.*;

public class HelenKeller {
    public static String solve(String[] p) {
        for (int i = 0; i < p.length; i++) {
            // Find where the equal sign is and set it to index variable
            if (p[i].equals("=")) {
                // Check if variable is on the right of the equal sign
                if (p[i + 1].matches(".*[a-zA-Z]")) {
                    String xTerm = p[i + 1];
                    char variable = xTerm.charAt(xTerm.length() - 1);
                    int coefficient = xTerm.equals(String.valueOf(variable)) ? 1 : Integer.parseInt(xTerm.substring(0, xTerm.length() - 1));
                    // Equation is on the left side
                    for (int j = 0; j < i; j++) {
                        switch (p[j]) {
                            case "+" -> {
                                int num1 = Integer.parseInt(p[0]);
                                int num2 = Integer.parseInt(p[2]);
                                double sum = num1 + num2;
                                double answer = sum / coefficient;
                                return String.format("%c = %.3f", variable, answer);
                            }
                            case "-" -> {
                                int num1 = Integer.parseInt(p[0]);
                                int num2 = Integer.parseInt(p[2]);
                                double difference = num1 - num2;
                                double answer = difference / coefficient;
                                return String.format("%c = %.3f", variable, answer);
                            }
                            case "*" -> {
                                int num1 = Integer.parseInt(p[0]);
                                int num2 = Integer.parseInt(p[2]);
                                double product = num1 * num2;
                                double answer = product / coefficient;
                                return String.format("%c = %.3f", variable, answer);
                            }
                            case "/" -> {
                                int num1 = Integer.parseInt(p[0]);
                                int num2 = Integer.parseInt(p[2]);
                                double quotient = (double) num1 / num2;
                                double answer = quotient / coefficient;
                                return String.format("%c = %.3f", variable, answer);
                            }
                        }
                    }
                } else {
                    // Variable is on the left of the equal sign
                    for (int j = 0; j < i; j++) {
                        if (p[j].matches(".*[a-zA-Z]")) {
                            String xTerm = p[j];
                            char variable = xTerm.charAt(xTerm.length() - 1);
                            int coefficient = xTerm.equals(String.valueOf(variable)) ? 1 : Integer.parseInt(xTerm.substring(0, xTerm.length() - 1));
                            if (p[0].equals(xTerm)) {
                                switch (p[1]) {
                                    case "+", "/", "*" -> {
                                        int num = Integer.parseInt(p[2]);
                                        double answer = (double) num / coefficient;
                                        return String.format("%c = %.3f", variable, answer);
                                    }
                                    case "-" -> {
                                        int num = Integer.parseInt(p[2]);
                                        double answer = (double) -num / coefficient;
                                        return String.format("%c = %.3f", variable, answer);
                                    }
                                }
                            } else if (p[2].equals(xTerm)) {
                                switch (p[1]) {
                                    case "+", "-", "*", "/" -> {
                                        int num = Integer.parseInt(p[0]);
                                        double answer = (double) num / coefficient;
                                        return String.format("%c = %.3f", variable, answer);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("helen.dat"));
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                if (sc.hasNextLine()) {
                    String equation = sc.nextLine();
                    String[] parts = equation.split(" ");
                    String result = solve(parts);
                    if (!result.isEmpty()) {
                        System.out.println(result);
                    }
                }
            }
        }
    }
}