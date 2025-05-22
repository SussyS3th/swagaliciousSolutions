import java.util.*;
import java.io.*;
public class kendrickSpiralBaby {

    public static int[][] solve(int n, int startRow, int startCol, int counter) {

        int[][] matrix = new int[n][n];
        int dir = 0; // 0 -> right, 1 -> down, 2 -> left, 3 -> up
        int row = startRow, col = startCol;

        int[] dRow = {0, 1, 0, -1}; // direction vector for rows
        int[] dCol = {1, 0, -1, 0}; // direction vector for columns

        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = counter++;
            int newRow = row + dRow[dir];
            int newCol = col + dCol[dir];

            // Check if the new cell is out of bounds or already filled
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || matrix[newRow][newCol] != 0) {
                dir = (dir + 1) % 4; // Change direction
                newRow = row + dRow[dir];
                newCol = col + dCol[dir];
            }

            row = newRow;
            col = newCol;
        }
        return matrix;
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("spiral.dat"));
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int[][] matrix = solve(a, 0, 0, 1);

            int maxNum = a * a;
            int maxDigits = Integer.toString(maxNum).length();

            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.printf("%-" + (maxDigits + 1) + "d", val); // ngl I looked this statement up
                }
                System.out.println();
            }
            // System.out.println();
        }
    }
}