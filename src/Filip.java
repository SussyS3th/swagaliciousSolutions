import java.util.*;
import java.io.*;

public class Filip {
    public static char[][] solve(int r, int c, char k, boolean b) {
        char[][] mat = new char[r][c];
        if (b) {
            // fill the entire matrix
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = k;
                }
            }
        }
        else {
            // only fill left, right, top and bottom rows/columns
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == 0 || i == r - 1) mat[i][j] = k;
                    else if (j == 0 || j == c - 1) mat[i][j] = k;
                    else mat[i][j] = ' ';
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("filip.dat"));
        int nCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nCases; i++) {
            String s = sc.nextLine().replaceAll(" ", "");
            String[] arr = s.split("");

            int r = Integer.parseInt(arr[0]);
            int c = Integer.parseInt(arr[1]);
            char k = arr[2].charAt(0);
            boolean b = true;
            if (arr[3].equals("f")) b = false;

            char[][] matrix = solve(r, c, k, b);

            for (int j = 0; j < r; j++) {
                for (int l = 0; l < c; l++) {
                    System.out.print(matrix[j][l]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}