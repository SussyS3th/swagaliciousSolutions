import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("calculator.dat"));
        int numExpressions = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int i = 0; i < numExpressions; i++) {
            String expression = scanner.nextLine();
            String postfixExpression = infixToPostfix(expression);
            int result = evaluatePostfix(postfixExpression);
            System.out.println(result);
        }
    }

    private static String infixToPostfix(String expression) {
        String[] tokens = expression.split(" ");
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else {
                postfix.append(token).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private static int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Integer division
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}