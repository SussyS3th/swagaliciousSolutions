import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Counter {
    private static int countGroup(String[][] matrix, int row, int col) {
        int count = 0;
        if (row > 0 && matrix[row-1][col].equals("$")) {
            count++;
            matrix[row-1][col] = ".";
            count = count + countGroup(matrix, row-1, col);
        }
        if (row < matrix.length-1 && matrix[row+1][col].equals("$")) {
            count++;
            matrix[row+1][col] = ".";
            count = count + countGroup(matrix, row+1, col);
        }
        if (col > 0 && matrix[row][col-1].equals("$")) {
            count++;
            matrix[row][col-1] = ".";
            count = count + countGroup(matrix, row, col-1);
        }
        if (col < matrix[0].length-1 && matrix[row][col+1].equals("$")) {
            count++;
            matrix[row][col+1] = ".";
            count = count + countGroup(matrix, row, col+1);
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("pr90.dat"));
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

        int num = scanner.nextInt();
        for (int k = 0; k < num; k++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int count = 0;
            if (matrix[row][col].equals("$")) {
                count++;
                matrix[row][col] = ".";
                count = count + countGroup(matrix, row, col);
            }
            System.out.println("(" + row + "," + col + ") - " + count);
        }
    }
}