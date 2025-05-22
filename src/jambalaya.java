import java.io.*;
import java.util.*;
public class jambalaya {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("pr35.dat"));
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int t = 0; t < testCases; t++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            char[][] rearrangedMatrix = rearrangeMatrix(matrix, rows, cols);
            printMatrix(rearrangedMatrix, rows, cols);

            if (t < testCases - 1) {
                System.out.println();
            }
        }
    }

    private static char[][] rearrangeMatrix(char[][] matrix, int rows, int cols) {
        char[][] tempMatrix = new char[rows][cols];

        // odd columns first, then even columns
        int colIndex = 0;
        for (int j = 0; j < cols; j += 2) {
            for (int i = 0; i < rows; i++) {
                tempMatrix[i][colIndex] = matrix[i][j];
            }
            colIndex++;
        }
        for (int j = 1; j < cols; j += 2) {
            for (int i = 0; i < rows; i++) {
                tempMatrix[i][colIndex] = matrix[i][j];
            }
            colIndex++;
        }

        // odd rows first, then even rows
        char[][] rearrangedMatrix = new char[rows][cols];
        int rowIndex = 0;
        for (int i = 0; i < rows; i += 2) {
            for (int j = 0; j < cols; j++) {
                rearrangedMatrix[rowIndex][j] = tempMatrix[i][j];
            }
            rowIndex++;
        }
        for (int i = 1; i < rows; i += 2) {
            for (int j = 0; j < cols; j++) {
                rearrangedMatrix[rowIndex][j] = tempMatrix[i][j];
            }
            rowIndex++;
        }

        return rearrangedMatrix;
    }

    private static void printMatrix(char[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}