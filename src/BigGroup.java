import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BigGroup {
    private static int countGroup(String[][] matrix, int row, int col) {
        int count = 0;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col].equals("$")) {
            count++;
            matrix[row][col] = ".";
            count += countGroup(matrix, row - 1, col);
            count += countGroup(matrix, row + 1, col);
            count += countGroup(matrix, row, col - 1);
            count += countGroup(matrix, row, col + 1);
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr91.dat"));
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int largestGroup = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals("$")) {
                    int groupSize = countGroup(matrix, i, j);
                    if (groupSize > largestGroup) {
                        largestGroup = groupSize;
                    }
                }
            }
        }

        System.out.println("Biggest group of $s is " + largestGroup + ".");
    }
}